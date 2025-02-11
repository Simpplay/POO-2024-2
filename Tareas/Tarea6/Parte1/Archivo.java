package Tareas.Tarea6.Parte1;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Archivo {

    private final String nombre;
    private final File file;

    private static final String SEPARADOR = "!";

    public Archivo(String nombre) throws IOException, URISyntaxException {
        this.nombre = nombre;
        this.file = getOrCreateFile(nombre);
    }

    private static File getOrCreateFile(String nombre) throws IOException, URISyntaxException {
        File file = new File(getJARFolder().getPath() + File.separator + nombre);
        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw new IOException("Failed to create file: " + file.getAbsolutePath());
            }
        }
        return file;
    }

    private static File getJARFolder() throws URISyntaxException {
        return new File(Archivo.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile();
    }

    public String getNombre() {
        return nombre;
    }

    public File getFile() {
        return file;
    }

    public synchronized void addRegistry(Contacto contacto) throws IOException {
        Optional<ContactEntry> entry = readRegistry(contacto.nombre());

        try (RandomAccessFile accessFile = new RandomAccessFile(file, "rw")) {
            if (entry.isPresent()) {
                accessFile.seek(entry.get().byteOffset()); // Se posiciona en el byte en el que inicia el registro
                accessFile.writeBytes(contacto.nombre() + SEPARADOR + contacto.telefono() + System.lineSeparator());
            } else {
                accessFile.seek(accessFile.length());
                accessFile.writeBytes(contacto.nombre() + SEPARADOR + contacto.telefono() + System.lineSeparator());
            }
        }
    }

    public synchronized Optional<ContactEntry> readRegistry(String nombre) throws IOException {
        try (RandomAccessFile accessFile = new RandomAccessFile(file, "r")) {
            String line;

            // Se necesita guardar el byte en el que inicia el registro, para poder actualizarlo
            long byteOffset = 0;  // Toma nota de la posición del byte en la que se encuentra la línea actual

            while ((line = accessFile.readLine()) != null) {
                long currentOffset = byteOffset;  // Guarda el byte en el que inicia el registro actual
                byteOffset = accessFile.getFilePointer();  // Actualiza la posición del byte a la del siguiente registro

                String[] parts = line.split(SEPARADOR);
                if (parts[0].equals(nombre)) {
                    return Optional.of(new ContactEntry(new Contacto(parts[0], parts[1]), currentOffset));
                }
            }
        }
        return Optional.empty();
    }

    public synchronized List<ContactEntry> getAllRegistries() throws IOException {
        String line;
        List<ContactEntry> entries = new ArrayList<>();

        try (RandomAccessFile accessFile = new RandomAccessFile(file, "r")) {
            long byteOffset = 0;
            while ((line = accessFile.readLine()) != null) {
                long currentOffset = byteOffset;
                byteOffset = accessFile.getFilePointer();

                String[] parts = line.split(SEPARADOR);
                entries.add(new ContactEntry(new Contacto(parts[0], parts[1]), currentOffset));
            }
        }
        return entries;
    }

    public synchronized boolean deleteRegistry(String nombre) throws IOException {
        List<ContactEntry> entries = getAllRegistries();
        boolean deleted = false;
        try (RandomAccessFile accessFile = new RandomAccessFile(file, "rw")) {
            accessFile.setLength(0);
            for (ContactEntry entry : entries) {
                if (!entry.contacto().nombre().equals(nombre)) {
                    accessFile.writeBytes(entry.contacto().nombre() + SEPARADOR + entry.contacto().telefono() + System.lineSeparator());
                }
                else {
                    deleted = true;
                }
            }
        }
        return deleted;
    }

    public record ContactEntry(Contacto contacto, long byteOffset) {}
}