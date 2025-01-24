package org.iesalandalus.programacion.matriculacion.modelo;

import org.iesalandalus.programacion.matriculacion.modelo.dominio.Alumno;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Asignatura;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.CicloFormativo;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Matricula;
import org.iesalandalus.programacion.matriculacion.modelo.negocio.*;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public class Modelo {

    private static Alumnos alumnos;
    private static Asignaturas asignaturas;
    private static CiclosFormativos ciclosFormativos;
    private static Matriculas matriculas;

    public void comenzar() {
        alumnos = new Alumnos();
        asignaturas = new Asignaturas();
        ciclosFormativos = new CiclosFormativos();
        matriculas = new Matriculas();
        System.out.println("Modelo iniciado.");
    }

    public void terminar() {
        System.out.println("Modelo terminado.");
    }

    public static void insertar(Alumno alumno) throws OperationNotSupportedException {
        alumnos.insertar(alumno);
    }

    public static Alumno buscar(Alumno alumno) {
        return alumnos.buscar(alumno);
    }

    public static void borrar(Alumno alumno) throws OperationNotSupportedException {
        alumnos.borrar(alumno);
    }

    public static List<Alumno> getAlumnos() {
        return alumnos.get();
    }

    public static void insertar(Asignatura asignatura) throws OperationNotSupportedException {
        asignaturas.insertar(asignatura);
    }

    public static Asignatura buscar(Asignatura asignatura) {
        return asignaturas.buscar(asignatura);
    }

    public static void borrar(Asignatura asignatura) throws OperationNotSupportedException {
        asignaturas.borrar(asignatura);
    }

    public static List<Asignatura> getAsignaturas() {
        return asignaturas.get();
    }

    public static void insertar(CicloFormativo cicloFormativo) throws OperationNotSupportedException {
        ciclosFormativos.insertar(cicloFormativo);
    }

    public static CicloFormativo buscar(CicloFormativo cicloFormativo) {
        return ciclosFormativos.buscar(cicloFormativo);
    }

    public static void borrar(CicloFormativo cicloFormativo) throws OperationNotSupportedException {
        ciclosFormativos.borrar(cicloFormativo);
    }

    public static List<CicloFormativo> getCiclosFormativos() {
        return ciclosFormativos.get();
    }

    public static void insertar(Matricula matricula) throws OperationNotSupportedException {
        matriculas.insertar(matricula);
    }

    public static Matricula buscar(Matricula matricula) {
        return matriculas.buscar(matricula);
    }

    public static void borrar(Matricula matricula) throws OperationNotSupportedException {
        matriculas.borrar(matricula);
    }

    public static List<Matricula> getMatriculas() {
        return matriculas.get();
    }

    public static List<Matricula> getMatriculas(Alumno alumno) {
        return matriculas.get(alumno);
    }

    public static List<Matricula> getMatriculas(CicloFormativo cicloFormativo) {
        return matriculas.get(cicloFormativo);
    }

    public static List<Matricula> getMatriculas(String cursoAcademico) {
        return matriculas.get(cursoAcademico);
    }
}
