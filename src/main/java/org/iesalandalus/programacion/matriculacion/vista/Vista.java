package org.iesalandalus.programacion.matriculacion.vista;

import org.iesalandalus.programacion.matriculacion.controlador.Controlador;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Alumno;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Asignatura;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.CicloFormativo;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Matricula;
import org.iesalandalus.programacion.utilidades.Entrada;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;

public class Vista {

    private static Controlador controlador;

    public void setControlador(Controlador controlador) {
        if (controlador == null) {
            throw new NullPointerException("ERROR: El controlador no puede ser nulo.");
        }
        Vista.controlador = controlador;
    }

    public void comenzar() {
        Opcion opcion = Opcion.SALIR;

        do {
            try {
                Consola.mostrarMenu();
                System.out.println();
                opcion = Consola.elegirOpcion();
                ejecutarOpcion(opcion);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (opcion != Opcion.SALIR);

        controlador.terminar();
    }

    public void terminar() {
        System.out.println("Hasta luego!!!!");
        System.out.println();
    }

    private void ejecutarOpcion(Opcion opcion) throws OperationNotSupportedException {
        switch (opcion) {
            case INSERTAR_ALUMNO: insertarAlumno(); break;
            case BUSCAR_ALUMNO: buscarAlumno(); break;
            case BORRAR_ALUMNO: borrarAlumno(); break;
            case MOSTRAR_ALUMNOS: mostrarAlumnos(); break;
            case INSERTAR_ASIGNATURA: insertarAsignatura(); break;
            case BUSCAR_ASIGNATURA: buscarAsignatura(); break;
            case BORRAR_ASIGNATURA: borrarAsignatura(); break;
            case MOSTRAR_ASIGNATURAS: mostrarAsignaturas(); break;
            case INSERTAR_CICLO_FORMATIVO: insertarCicloFormativo(); break;
            case BUSCAR_CICLO_FORMATIVO: buscarCicloFormativo(); break;
            case BORRAR_CICLO_FORMATIVO: borrarCicloFormativo(); break;
            case MOSTRAR_CICLOS_FORMATIVOS: mostrarCiclosFormativos(); break;
            case INSERTAR_MATRICULA: insertarMatricula(); break;
            case BUSCAR_MATRICULA: buscarMatricula(); break;
            case ANULAR_MATRICULA: anularMatricula(); break;
            case MOSTRAR_MATRICULAS: mostrarMatriculas(); break;
            case MOSTRAR_MATRICULAS_ALUMNO: mostrarMatriculasPorAlumno(); break;
            case MOSTRAR_MATRICULAS_CICLO_FORMATIVO: mostrarMatriculasPorCicloFormativo(); break;
            case MOSTRAR_MATRICULAS_CURSO_ACADEMICO: mostrarMatriculasPorCursoAcademico(); break;
        }
    }

    private static void insertarAlumno() {
        try {
            System.out.println();
            System.out.println("Datos del alumno");
            System.out.println("=============================================================================================");
            Alumno alumno = Consola.leerAlumno();
            controlador.insertar(alumno);
            System.out.println();
            System.out.println("Alumno insertado correctamente.");
        }
        catch (Exception e) {
            System.out.println("*" + e.getMessage());
        }
    }

    private static void buscarAlumno() {
        try {
            Alumno alumno = Consola.getAlumnoPorDni();
            alumno = controlador.buscar(alumno);

            if (alumno != null) {
                System.out.println("Alumno encontrado:");
                System.out.println(alumno);
            } else {
                System.out.println("Alumno no encontrado.");
            }
        }
        catch (Exception e) {
            System.out.println("*" + e.getMessage());
        }
    }

    private static void borrarAlumno() {
        try {
            Alumno alumno = Consola.getAlumnoPorDni();
            controlador.borrar(alumno);
            System.out.println("Alumno borrado correctamente.");
        }
        catch (Exception e) {
            System.out.println("*" + e.getMessage());
        }
    }

    private static void mostrarAlumnos() {
        Alumno[] listaAlumnos = controlador.getAlumnos();

        if (listaAlumnos[0] == null) {
            System.out.println("No hay alumnos registrados.");
        } else {
            System.out.println("Alumnos registrados:");
            for (Alumno alumno : listaAlumnos) {
                if (alumno != null) {
                    System.out.println(alumno);
                }
            }
        }
    }

    private static void insertarAsignatura() {
        try {
            System.out.println("Inserción de una asignatura:");
            System.out.println("=============================================================================================");
            System.out.println("-- Ciclo formativo de la asignatura --");
            mostrarCiclosFormativos();
            System.out.println();
            CicloFormativo cicloFormativo = Consola.getCicloFormativoPorCodigo();
            cicloFormativo = controlador.buscar(cicloFormativo);

            System.out.println();
            System.out.println("-- Datos de la asignatura --");

            Asignatura asignatura = Consola.leerAsignatura(new CicloFormativo(cicloFormativo));
            controlador.insertar(asignatura);
            System.out.println("Asignatura insertada correctamente.");
        }
        catch (Exception e) {
            System.out.println("*" + e.getMessage());
        }
    }

    private static void buscarAsignatura() {
        try {
            Asignatura asignatura = Consola.getAsignaturaPorCodigo();
            asignatura = controlador.buscar(asignatura);
            System.out.println();

            if (asignatura != null) {
                System.out.println("Asignatura encontrada:");
                System.out.println(asignatura);
            } else {
                System.out.println("Asignatura no encontrada.");
            }
        }
        catch (Exception e) {
            System.out.println("*" + e.getMessage());
        }
    }

    private static void borrarAsignatura() {
        try {
            Asignatura asignatura = Consola.getAsignaturaPorCodigo();
            controlador.borrar(asignatura);
            System.out.println();
            System.out.println("Asignatura borrada correctamente.");
        }
        catch (Exception e) {
            System.out.println("*" + e.getMessage());
        }
    }

    private static void mostrarAsignaturas() {
        Asignatura[] listaAsignaturas = controlador.getAsignaturas();

        if (listaAsignaturas[0] == null) {
            System.out.println("No hay asignaturas registradas.");
        } else {
            System.out.println("Asignaturas registradas:");
            for (Asignatura asignatura : listaAsignaturas) {
                if (asignatura != null) {
                    System.out.println(asignatura);
                }
            }
        }
    }

    private static void insertarCicloFormativo() {
        try {
            System.out.println("Datos del ciclo formativo");
            System.out.println("=============================================================================================");
            CicloFormativo ciclo = Consola.leerCicloFormativo();
            controlador.insertar(ciclo);
            System.out.println("Ciclo formativo insertado correctamente.");
        }
        catch (Exception e) {
            System.out.println("*" + e.getMessage());
        }
    }

    private static void buscarCicloFormativo() {
        try {
            CicloFormativo cicloFormativo = Consola.getCicloFormativoPorCodigo();
            cicloFormativo = controlador.buscar(cicloFormativo);
            System.out.println();

            if (cicloFormativo != null) {
                System.out.println("Ciclo formativo encontrado:");
                System.out.println(cicloFormativo);
            } else {
                System.out.println("Ciclo formativo no encontrado.");
            }
        }
        catch (Exception e) {
            System.out.println("*" + e.getMessage());
        }
    }

    private static void borrarCicloFormativo() {
        try {
            CicloFormativo cicloFormativo = Consola.getCicloFormativoPorCodigo();
            controlador.borrar(cicloFormativo);
            System.out.println();
            System.out.println("Ciclo formativo borrado correctamente.");
        }
        catch (Exception e) {
            System.out.println("*" + e.getMessage());
        }
    }

    private static void mostrarCiclosFormativos() {
        CicloFormativo[] listaCiclos = controlador.getCiclosFormativos();

        if (listaCiclos[0] == null) {
            System.out.println("No hay ciclos formativos registrados.");
        } else {
            System.out.println("Ciclos formativos registrados:");
            for (CicloFormativo cicloFormativo : listaCiclos) {
                if (cicloFormativo != null) {
                    System.out.println(cicloFormativo);
                }
            }
        }
    }

    private static void insertarMatricula() {
        try {
            System.out.println("Inserción de una matrícula");
            System.out.println("=============================================================================================");

            System.out.println("-- Datos del alumno --");
            Alumno alumno = Consola.leerAlumno();
            System.out.println();

            System.out.println("-- Asignaturas de la matrícula --");
            Asignatura[] asignaturasMatricula = Consola.elegirAsignaturasMatricula(controlador.getAsignaturas());
            System.out.println();

            System.out.println("-- Datos restantes --");
            Matricula matricula = Consola.leerMatricula(alumno, asignaturasMatricula);
            controlador.insertar(matricula);
            System.out.println("Matrícula insertada correctamente.");
        }
        catch (Exception e) {
            System.out.println("*" + e.getMessage());
        }
    }

    private static void buscarMatricula() {
        try {
            Matricula matricula = Consola.getMatriculaPorIdentificador();
            matricula = controlador.buscar(matricula);
            System.out.println();

            if (matricula != null) {
                System.out.println("Matrícula encontrada:");
                System.out.println(matricula);
            } else {
                System.out.println("No existe ninguna matrícula con ese identificador.");
            }
        }
        catch (Exception e) {
            System.out.println("*" + e.getMessage());
        }
    }

    private static void anularMatricula() {
        try {
            if (controlador.getMatriculas().length == 0) {
                System.out.println("No hay matrículas registradas para anular.");
                return;
            }

            mostrarMatriculas();
            System.out.println();
            Matricula matricula = Consola.getMatriculaPorIdentificador();
            matricula = controlador.buscar(matricula);

            if (matricula != null) {
                LocalDate fechaAnulacion = Consola.leerFecha("Introduce la fecha de anulación");
                matricula.setFechaAnulacion(fechaAnulacion);
                controlador.borrar(matricula);
                System.out.println();
                System.out.println("Matrícula anulada correctamente el " + fechaAnulacion + ".");
            } else {
                System.out.println("No existe ninguna matrícula con ese identificador.");
            }
        }
        catch (Exception e) {
            System.out.println("*" + e.getMessage());
        }
    }

    private static void mostrarMatriculas() throws OperationNotSupportedException {
        Matricula[] listaMatriculas = controlador.getMatriculas();

        if (listaMatriculas[0] == null) {
            System.out.println("No hay matrículas registradas.");
        } else {
            System.out.println("Matrículas registradas:");
            for (Matricula matricula : listaMatriculas) {
                if (matricula != null)
                    System.out.println(matricula);
            }
        }

    }

    private static void mostrarMatriculasPorAlumno() {
        try {
            Alumno alumno = Consola.getAlumnoPorDni();
            alumno = controlador.buscar(alumno);

            if (alumno == null) {
                System.out.println("El alumno no está registrado.");
                return;
            }

            Matricula[] matriculasAlumno = controlador.getMatriculas(alumno);

            if (matriculasAlumno[0] == null) {
                System.out.println("El alumno no tiene matrículas registradas.");
            } else {
                System.out.println("Matrículas del alumno " + alumno.getNombre() + ":");
                for (Matricula matricula : matriculasAlumno) {
                    if (matricula != null)
                        System.out.println(matricula);
                }
            }
        } catch (Exception e) {
            System.out.println("*" + e.getMessage());
        }
    }

    private static void mostrarMatriculasPorCicloFormativo() {
        try {
            if (controlador.getMatriculas().length == 0) {
                System.out.println("No hay ciclos formativos registrados.");
                return;
            }

            mostrarCiclosFormativos();
            CicloFormativo cicloFormativo = Consola.getCicloFormativoPorCodigo();
            cicloFormativo = controlador.buscar(cicloFormativo);

            if (cicloFormativo == null) {
                System.out.println("El ciclo formativo no está registrado.");
                return;
            }

            Matricula[] matriculasCiclo = controlador.getMatriculas(cicloFormativo);

            if (matriculasCiclo[0] == null) {
                System.out.println("El ciclo formativo no tiene matrículas registradas.");
            } else {
                System.out.println();
                System.out.println("Matrículas del ciclo formativo " + cicloFormativo.getNombre() + ":");
                for (Matricula matricula : matriculasCiclo) {
                    if (matricula != null) {
                        System.out.println(matricula);
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println("*" + e.getMessage());
        }
    }

    private static void mostrarMatriculasPorCursoAcademico() {
        try {
            System.out.println("Introduce el curso academico:");
            String cursoAcademico = Entrada.cadena();

            Matricula[] matriculasCurso = controlador.getMatriculas(cursoAcademico);

            if (matriculasCurso[0] == null) {
                System.out.println("No hay matrículas registradas para el curso académico " + cursoAcademico + ".");
            } else {
                System.out.println();
                System.out.println("Matrículas registradas para el curso académico " + cursoAcademico + ":");
                for (Matricula matricula : matriculasCurso) {
                    if (matricula != null) {
                        System.out.println(matricula);
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println("*" + e.getMessage());
        }
    }

}
