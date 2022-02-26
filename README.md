# Pokedex
Pokemon Pokedex designed with Window Builder (Swing) in Eclipse

## Descripción
Aplicación compuesta por cuatro vistas creadas con Window Builder (Swing) en Eclipse.
La vista principal es la PokedexView() que muestra las características principales de los Pokemon que están registrados en la base de datos vinculada a la aplicación con el conector a Java JDBC de MySQL.

## Instrucciones
#### LoginView()
1. Acceso a aplicación con una vista de Login LoginView().
#### RegisterView()
2. En el primer acceso, deberá acceder a la vista de registro RegisterView() para registrarse y posteriormente acceder.
#### PokedexView()
3. Podrá navegar con los botones superior izquierdo y derecho para ver los Pokémons almacenados en la base de datos.
4. Si lo desea, puede eliminar el Pokémon que está visualizando si pulsa el botón Eliminar,
5. o modificar sus características activando el Modo edición, con el que podrá guardar los cambios o pulsar de nuevo el botón Modo edición si no desea aplicar los cambios.
6. También puede crear un nuevo Pokémon con el botón Crear, que abrirá la vista PokeCreatorView().
#### PokeCreatorView()
7. En esta vista se puede introducir los datos de un nuevo Pokémon y guardarlo en la base de datos.

## Mejoras por implementar
1. Cuando se crean los Pokémon, si el segundo Tipo es nulo (no se selecciona ninguna opción), aparecerá impreso en la Pokédex como "null" y en la BD se guarda como una cadena de caracteres que dice "null". Lo ideal sería que apareciera en blanco.
2. Si queremos establecer como nulo el segundo Tipo de un Pokémon que estamos editando (es decir, anteriormente habíamos seleccionado un segundo Tipo para este Pokémon), cuando pulsamos el botón Guardar, no se desactiva el modo edición pero sí se guardan los cambios. Hay que pulsar el botón "MODO EDICIÓN" y entonces se verán los cambios.
