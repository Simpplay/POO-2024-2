import os
from fpdf import FPDF

# Función para agregar código fuente a PDF
def agregar_codigo_a_pdf(pdf, ruta_archivo):
    with open(ruta_archivo, 'r') as archivo:
        contenido = archivo.read()
    pdf.set_font('Courier', 'B', 10)
    pdf.multi_cell(0, 10, contenido)

# Crear el archivo PDF
pdf = FPDF()
pdf.set_auto_page_break(auto=True, margin=15)
pdf.add_page()

# Portada en formato APA
pdf.set_font('Arial', 'B', 16)
pdf.cell(0, 10, 'Universidad Nacional de Colombia', 0, 1, 'C')
pdf.set_font('Arial', 'B', 14)
pdf.cell(0, 10, 'Autores:', 0, 1, 'L')
pdf.set_font('Arial', '', 12)
pdf.cell(0, 10, '1: Juan José Jiménez Maya', 0, 1, 'L')
pdf.cell(0, 10, 'Programa: Programación Orientada a Objetos', 0, 1, 'L')
pdf.cell(0, 10, 'Grupo: 3', 0, 1, 'L')
pdf.ln(10)

# Recorrer y agregar archivos .java
directorio_tareas = 'Tareas'  # Ajusta esto según la estructura de tu repositorio
for carpeta in os.listdir(directorio_tareas):
    ruta_carpeta = os.path.join(directorio_tareas, carpeta)
    if os.path.isdir(ruta_carpeta):
        pdf.set_font('Arial', 'B', 14)
        pdf.cell(0, 10, f'Tarea: {carpeta}', 0, 1, 'L')
        pdf.ln(5)
        for archivo in os.listdir(ruta_carpeta):
            if archivo.endswith('.java'):
                ruta_archivo = os.path.join(ruta_carpeta, archivo)
                agregar_codigo_a_pdf(pdf, ruta_archivo)
                pdf.ln(5)

# Guardar el archivo PDF
pdf_output_path = '/tareas/output.pdf'
pdf.output(pdf_output_path)
