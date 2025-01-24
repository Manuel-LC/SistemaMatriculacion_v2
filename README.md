# Tarea: Sistema de Matriculación
## Profesor: Andrés Rubio del Río
## Alumno: Manuel López Castillo

En este tercer spring de la tarea deberás modelar la gestión de las **matrículas de alumnos del IES Al-Ándalus**, 
eliminando la restricción de tamaño en los datos de la aplicación. Por lo que decidimos utilizar estructuras dinámicas de datos, en concreto **Listas**.

Para las diferentes clases del modelo que contienen las colecciones de objetos del dominio (las que están incluidas en el paquete **negocio**) 
deberemos sustituir los **Array** por **ArrayList** y, cómo no, ajustar los diferentes métodos para que sigan haciendo lo mismo que antes, 
pero utilizando las nuevas estructuras de datos. Como observarás, muchos de los métodos privados que teníamos antes desaparecen, ya 
que ahora no serán necesarios.

Por otro lado, dado el buen hacer en la segunda entrega, se ha decidido que se **añada la ordenación de los datos a la hora de listarlos 
en la vista** para tener un mejor control y organización. En este caso deberás modificar los correspondientes métodos de mostrar y 
listar para que los resultados aparezcan ordenados de la siguiente manera:

- El listado de Alumnos (método `mostrarAlumnos`) deberá mostrarse ordenado alfabéticamente de la A a la Z por el nombre.
- El listado de Asignaturas (método `mostrarAsignaturas`) deberá mostrarse ordenado alfabéticamente de la A a la Z por el nombre.
- El listado de Ciclos Formativos (método `mostrarCiclosFormativos`) deberá mostrarse ordenado alfabéticamente de la A a la Z por el nombre.
- En el listado de Matrículas (métodos `mostrarMatriculasXXX`), éstas se mostrarán ordenadas por la fecha de matriculación en orden descendente 
- (de las más recientes, a las más antiguas). En caso de que existan varias matrículas en la misma fecha, se realizará una segunda ordenación 
- por el nombre del alumno matriculado en orden alfabético de la A a la Z.

Para todo esto, a continuación te muestro como queda el diagrama de clases con las modificaciones y poco a poco te iré explicando 
los diferentes pasos a realizar:

![](https://www.juntadeandalucia.es/educacion/gestionafp/datos/tareas/DAW/PRO_18966254/2024-25/DAW_PRO_7_2024-25_Individual__747917/DiagramaV3.png)


#### Primeros Pasos
1. Realiza un **fork** del repositorio de tu tarea anterior en otro nuevo llamado SistemaMatriculacion_v2. Dicho repositorio lo clonarás localmente y realizarás las diferentes modificaciones que se piden en esta tarea.
2. Modifica tu fichero README.
3. Realiza tu primer **commit**.

#### Matricula
1. Modifica los métodos necesarios para utilizar ArrayLists en vez de Arrays.
2. Realiza un **commit** con la nueva clase creada.

#### Alumnos
1. Modifica la clase `Alumnos` para que utilice un ArrayList en vez de un Array.
   Elimina aquellos atributos y métodos que ya no sean necesarios, al utilizar esta nueva estructura.
   Realiza el **commit** correspondiente.

#### Matriculas
1. Modifica la clase `Matriculas` para que utilice un ArrayList en vez de un Array.
2. Elimina aquellos atributos y métodos que ya no sean necesarios, al utilizar esta nueva estructura.
3. Realiza un **commit** con la modificación de este enumerado.

#### Asignaturas
1. Modifica la clase `Asignaturas` para que utilice un ArrayList en vez de un Array.
2. Elimina aquellos atributos y métodos que ya no sean necesarios, al utilizar esta nueva estructura.
3. Realiza el **commit** correspondiente.

#### CiclosFormativos
1. Modifica la clase `CiclosFormativos` para que utilice un ArrayList en vez de un Array.
2. Elimina aquellos atributos y métodos que ya no sean necesarios, al utilizar esta nueva estructura.
3. Realiza el **commit** correspondiente.

#### Modelo
1. Elimina la constante **CAPACIDAD**, puesto que ya no tienes limitaciones de memoria.
2. Modifica los métodos necesarios para utilizar ArrayLists en vez de Arrays.
3. Realiza un **commit** con la nueva clase creada.

#### Controlador
1. Modifica los métodos necesarios para utilizar ArrayLists en vez de Arrays.
2. Realiza un **commit** con la nueva clase creada.

#### Vista
1. Modifica los métodos necesarios para utilizar ArrayLists en vez de Arrays.
2. Modifica el método ``mostrarAlumnos`` para que aplique la ordenación descrita anteriormente.
3. Modifica el método ``mostraAsignaturas`` para que aplique la ordenación descrita anteriormente.
4. Modifica el método ``mostrarCiclosFormativos`` para que aplique la ordenación descrita anteriormente.
5. Modifica los métodos ``mostrarMatriculasXXX`` para que aplique la ordenación descrita anteriormente.
6. Realiza un **commit** con la nueva clase creada.

#### Consola
1. Modifica los métodos necesarios para utilizar ArrayLists en vez de Arrays.
2. Realiza un **commit** con la nueva clase creada.

#### Se valorará:

- La indentación debe ser correcta en cada uno de los apartados.
- El nombre de las variables debe ser adecuado.
- Se debe utilizar la clase **Entrada** para realizar la entrada por teclado.
- El programa debe pasar todas las pruebas que van en el esqueleto del proyecto y toda entrada del programa será validada, para evitar que el programa termine abruptamente debido a una excepción.
- La corrección ortográfica tanto en los comentarios como en los mensajes que se muestren al usuario.
