import os
from fpdf import FPDF, HTMLMixin
from pygments import highlight
from pygments.lexers import JavaLexer

from pygments.formatters import *


class TaskPDF(FPDF, HTMLMixin):
    def add_cover(self, task_name, part):
        self.add_page()

        # Professional Cover Page
        self.set_font("Arial", "B", 20)
        self.cell(0, 10, "Universidad Nacional de Colombia", align="C", ln=1)
        self.ln(20)

        self.set_font("Arial", "B", 16)
        self.cell(0, 10, f"{task_name} - {part}", align="C", ln=1)
        self.ln(30)

        self.set_font("Arial", "", 14)
        self.cell(0, 10, "Autores:", ln=1, align="C")
        self.cell(0, 10, "Juan José Jiménez Maya", ln=1, align="C")
        self.ln(10)

        self.cell(0, 10, "Programa: Programación Orientada a Objetos", ln=1, align="C")
        self.cell(0, 10, "Grupo: 3", ln=1, align="C")
        self.ln(20)

    def image_add_code_file(self, file_path, github_url):
        self.add_page()
        self.set_font("Arial", "B", 12)
        self.cell(0, 10, f"Código: {os.path.basename(file_path)}", ln=1)
        # self.ln(5)

        # Read and highlight code
        with open(file_path, "r", encoding="utf-8") as file:
            code = file.read()

        lexer = JavaLexer()
        f = JpgImageFormatter()
        highlighted_code = highlight(code, lexer, f)
        path = os.path.join(os.getcwd(), "code.jpg")
        with open(path, "wb") as file:
            file.write(highlighted_code)

        # Add highlighted code to PDF
        self.image(path, w=350)

        # Add GitHub link
        self.set_font("Arial", "I", 10)
        self.cell(0, 10, f"Enlace: {github_url}", ln=1, link=github_url)

    def add_code_file(self, file_path, github_url):
        self.add_page()
        self.set_font("Arial", "B", 12)
        self.cell(0, 10, f"Código: {os.path.basename(file_path)}", ln=1)
        self.ln(5)

        # Read and highlight code
        with open(file_path, "r", encoding="utf-8") as file:
            code = file.read()

        lexer = JavaLexer()
        f = NullFormatter()
        highlighted_code = highlight(code, lexer, f)

        # Add highlighted code to PDF
        self.set_font("Courier", "", 8)
        self.multi_cell(0, 4, highlighted_code)

        # Add GitHub link
        self.set_font("Arial", "I", 10)
        self.cell(0, 10, f"Enlace: {github_url}", ln=1, link=github_url)

    def add_image_file(self, image_path, github_url):
        self.add_page()
        self.set_font("Arial", "B", 12)
        self.cell(0, 10, f"Imagen: {os.path.basename(image_path)}", ln=1)
        self.ln(5)

        # Resize and add image to fit page
        self.image(image_path, w=190)

        # Add GitHub link
        self.set_font("Arial", "I", 10)
        self.cell(0, 10, f"Enlace: {github_url}", ln=1, link=github_url)



def add_to_pdf(pdf, file_path):
    relative_path = os.path.relpath(file_path, project_directory)
    github_url = f"{github_repository_url}/{relative_path.replace(os.sep, '/')}"

    if file_path.endswith(".java"):
        pdf.add_code_file(file_path, github_url)
    elif file_path.endswith(".png"):
        pdf.add_image_file(file_path, github_url)

# Function to generate PDF for each task
def generate_task_pdfs(project_path):
    tareas_path = os.path.join(project_path, "Tareas")
    pdf_output_path = os.path.join(project_path, "pdf")

    # Crear la carpeta pdf si no existe
    if not os.path.exists(pdf_output_path):
        os.makedirs(pdf_output_path)

    for tarea_path in [ f.path for f in os.scandir(tareas_path) if f.is_dir() ]:
        for parte_path in [ f.path for f in os.scandir(tarea_path) if f.is_dir() ]:
            tarea = os.path.basename(tarea_path)
            parte = os.path.basename(parte_path)

            pdf = TaskPDF()
            pdf.add_cover(tarea, parte)

            def scan_files(path):
                for file in os.scandir(path):
                    if file.is_file():
                        yield file.path
                    else:
                        yield from scan_files(file.path)

            for file in scan_files(parte_path):
                add_to_pdf(pdf, file)
                

            # Ruta completa del archivo de salida PDF
            output_path = os.path.join(pdf_output_path, f"{tarea}_{parte}.pdf")

            # Guardar el archivo PDF
            pdf.output(output_path)
            print(f"PDF generado: {output_path}")


# Ruta del proyecto y base URL del repositorio de GitHub
project_directory = os.getcwd()
github_repository_url = "https://github.com/Simpplay/POO-2024-2/tree/master/"

# Generar PDFs para cada tarea
generate_task_pdfs(project_directory)
