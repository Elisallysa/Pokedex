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

## Bugs no solucionados
1. Los ComboBox() no están correctamente implementados e imposibilitan la actualización y creación de nuevos Pokémon.
