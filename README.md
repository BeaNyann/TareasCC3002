# TareasCC3002 : Alpaca Emblem

## :beginner: **Introducción**

Alpaca Emblem consiste en un juego de estrategia por turnos con distintos tipos de unidades que tienen fortalezas y debilidades entre ellas. 

## :beginner: **Información del proyecto**

El juego tiene el modelo, un controlador que manejará todos los cambios que ocurran en el juego y los Tactician, que corresponden a los jugadores.<br />
<br />
Primero se explicará el modelo:<br />
<br />
El juego posee 7 tipos de unidades.<br />
<br />
Cada una con sus respectivos Hit Points (cantidad de daño que pueden recibir), Movement (Cantidad máxima de celdas del mapa que puede desplazarse), Location (Ubicación actual de la unidad en el mapa) e Items (Lista de objetos que porta la unidad).<br />
<br />
Cada tipo de unidad puede equiparse distintos tipos de objetos (Items):<br />
<br />
+ Los Archer se equipan Bows.
+ Los fighter se equipan Axes.
+ Los Sword Master se equipan Swords.
+ Los Cleric se equipan Staffs.
+ Los Hero se equipan Spears.
+ Los Sorcerer pueden equiparse Magic Books (ya sea Dark Magic Book, Light Magic Book o Spirit Magic Book).
+ Las Alpacas no pueden equiparse nada.<br />
<br />
Los items tienen cada uno su respectivo Power (su daño/poder base), un minRange y maxRange (corresponde el rango a donde pueden llegar sus ataques).<br /> 
<br />
Los item tienen debilidades y fortalezas:<br />
<br />

- Axe es debil contra Sword y fuerte contra Spear.
- Sword es debil contra Spear y fuerte contra Axe.
- Spear es debil contra Axe y fuerte contra Sword.
- Los 3 Magic Books son fuertes contra todos los demás items no-mágicos y viceversa.
- El Spirit Magic Book es debil contra el Dark Magic Book y fuerte contra el Light Magic Book.
- El Dark Magic Book es debil contra el Light Magic Book y fuerte contra Spirit Magic Book.
- El Light Magic Book es debil contra el Spirit Magic Book y fuerte contra el Dark Magic Book.<br />
<br />
Todas las unidades pueden atacar a otras, excepto 2:<br />
<br />
Los Cleric solo pueden curar otras unidades y las Alpacas no pueden atacar ya que no pueden equiparse items.<br />
<br />
Las unidades pueden dar y recibir objetos de otras unidades, pero para ello deben estar a distancia 1 en el mapa.<br />
<br />
El mapa esta compuesto por celdas, distribuidas en forma de cuadricula.<br />
<br />
No pueden haber dos unidades en la misma celda del mapa y solo pueden desplazarse por celdas adyacentes, que pertenezcan al tablero del juego.<br />
<br />
Las unidades pueden combatir entre ellas, la ocurrencia o no del combate depende de varios factores:<br />
<br />
Si la unidad atacante tiene un objeto equipado, si la unidad que recibe el ataque esta en un rango válido para el item atacante, etc. <br />
<br />
Y luego de un ataque, siempre que pueda, la unidad víctima va a realizar un contraataque.<br />
<br />
A continuación se explicarán las facultades del controller y el tactician:<br />
<br />
El controlador posee la capacidad de acceder a todas las funcionalidades antes mencionadas.<br />
<br />
Tiene el poder de iniciar una partida donde debe resetear todos los valores necesarios, como por ejemplo revivir a los tacticians que perdieron la vida en la partida anterior, devolverles sus unidades, entre otros. La partida puede tener un límite de rondas o ser "infinita".<br />
<br />
Posee control sobre todos los Tacticians que participen en el juego, es capaz de administrar las interacciones entre sus unidades, ya sea entre las unidades del mismo tactician, como entre las unidades de diferentes tactician (para el metodo de ataque por ejemplo). Es capaz de crear a todos los tactician al principio de una partida y de crear y asignarle sus unidades.<br />
<br />
Tiene conocimiento de que tactician se encuentra jugando en este momento y puede mandar la instruccion para que este finalice su turno y comience el turno del siguiente.<br />
<br />
Es capaz de crear un mapa aleatorio para cada juego y de mantener una referencia a este durante su desarrollo, de donde puede obtener las unidades en cada celda, que celdas son vecinas entre ellas, entre otros.<br />
<br />
El controlador se encarga de retirar a los tactician que hayan perdido todas sus unidades o que hayan perdido su Hero, terminando su turno en caso de que sea necesario.<br />
<br />
Cuando todos los tactician juegan su turno, el controller se encarga de comenzar una nueva ronda cambiando el orden en que jugarán los tactician, asegurandose de que nadie tenga dos turnos seguidos.<br />
<br />
El controller también se encarga de decidir quienes ganaron el juego, si la partida es sin límite de rondas el ganador será el ultimo tactician en pie, si la partida tiene un máximo de rondas el ganador solo se decide al acabarse estas rondas, ganando los tactician sobrevivientes que tengan más unidades vivas.<br />
<br />
El tactician representa el estado de un jugador durante el juego. Este debe delegar todas las llamadas a metodos a los metodos de los objetos del modelo. Este posee conocimiento de todas sus unidades, sus respectivas ubicaciones y datos como puntos de vida, items que posee, item equipado, etc. También posee conocimiento del mapa del juego.

## :beginner: **Documentación**

El juego actualmente no posee forma de ejecutarse, pero se ha comprobado la funcionalidad de todos sus metodos a travez de múltiples tests.<br />
<br />
Para descargarlo debes clonar este repositorio en tu propio computador y ejecutarlo en alguna IDE que reconozca el lenguaje JAVA.<br />
<br />
A continuación se explicarán los metodos, clases, interfaces, y la funcionalidad en general de este proyecto que parezca necesario explicar del modelo:<br />
<br />
### **Los items:**<br />
<br />
La interfaz IEquipableItem posee todos los metodos que son comunes para todos los items, que son los siguientes:<br />
<br />

* void equipTo(IUnit unit): Le manda un mensaje a la unidad ingresada para que se equipe este item, siempre y cuando nadie más lo tenga equipado.<br />
<br />

* IUnit getUser()/void setUser(IUnit user): Entrega/Establece la unidad que tiene equipado este item. Si nadie lo tiene equipado entrega null.<br />
<br />

* IUnit getOnInventory /void setOnInventory(Iunit, user): Entrega/Establece la unidad que posee este item en su inventario.<br />
<br />

* void attackWith(IUnit unit): Le manda un mensaje a la unidad que recibe el ataque con el item que la está atacando.<br />
<br />

* void weAtacckedBy...(...): Existe una para cada item y le manda un mensaje a la unidad que tiene equipado este item indicando el tipo de daño recibido (Normal, Fuerte o Debil) dependiendo de que item está atacando y que item es el que llamó al metodo.<br />
<br />
Luego, en la clase abstracta se realiza un Override de la mayoría de los metodos antes mencionados, excepto attackWith, ya que no posee un comportamiento default para varios items, sino que depende exclusivamente de que tipo de item realiza el llamado. Lo mismo ocurre con los metodos equipTo.<br />
<br />
Pero en esta clase se agrega un metodo boolean equals(Object) que realiza un Override a la clase Object, que es para comparar dintintos items, revisando que cada uno de sus campos sean iguales. Se hace además un Override de todos los attackedBy.. en donde se asigna a todos daño normal, para que solo en caso que corresponda se cambie a daño fuerte o debil.<br />
<br />
Luego, en cada item se hace Override de equipTo, en donde se le indica a la unidad que se equipe este item. Se hace un Override de attackWith en donde se le indica a la unidad atacada que esta siendo atacada con este item, con la única excepcion de la implementada por el Staff que llama al metodo healedByStaff ya que este suma vida, no la resta.<br />
<br />
Según las debilidades y fortalezas se hace Override a los metodos que correspondan para cambiarles la cantidad de daño.<br />
<br />

### **Las Unidades:**<br />
<br />
La interfaz IUnit posee todos los metodos que son comunes para todas las unidades, que son los siguientes:<br />
<br />

* double getCurrentHitPoints(): Entrega la cantidad actual de vida de la unidad.<br />
<br />

* double getMaxHitPoints(): Entrega el maximo de vida que puede tener una unidad, eso no cambia a lo largo del juego.<br />
<br />

* List<IEquipableItem> getItems(): Entrega la lista de items que posee la unidad en su inventario.<br />
<br />

* IEquipableItem getEquippedItem(): Entrega el item que la unidad tiene equipado, si no tiene uno es null.<br />
<br />

* void unequipItem(): Cambia el "EquipedItem" de la unidad a null y le indica al item que establezca que la unidad que lo tiene equipado es null (nadie lo tiene equipado).<br />
<br />

* Location getLocation()/void setLocation(Location location): Entrega/Establece la posición actual de la unidad.<br />
<br />

* int getMovement(): Entrega el numero de celdas que la unidad se puede mover.<br />
<br />

* void moveTo(Location targetLocation): Mueve la unidad a la celda indicada, siempre y cuando sea alcanzable y a una distancia menor o igual a la cantidad de celdas que la unidad se puede mover de donde se encuentra en ese momento.<br />
<br />

Luego se encuentran los metodos equip que en cada unidad se va a hacer Override solo a los que correspondan (a los de items que puedan equiparse).<br />
<br />
* boolean receiveObj(IEquipableItem item): Le entrega un item a la unidad siempre y cuando esta tenga espacio y entrega true si es que efecivamente lo recibió.<br />
<br />

* void giveObj(IUnit unit, IEquipable item): Le manda un mensaje a otra unidad para traspasarle un objeto, checkea que la unidad posea el objeto que quiere entregar y que se encuentre a distancia 1 de la otra unidad, trata de entregarselo y si efectivamente la otra unidad lo recibe (es decir, si tenía espacio) lo remueve de su lista de objetos.<br />
<br />

* void addItem(IEquipableItem item): Añade un item al inventario, siempre que haya espacio.<br />
<br />

* void removeItem(IEquipableItem item): Remueve un item del inventario, siempre que este item se encuentre en el inventario.<br />
<br />
Luego vienen los metodos attackedBy... en donde la unidad le manda un mensaje a su item indicándole con que están atacando.<br />
<br />

* void setNormalDamage(double power)/void setBigDamage(double power)/void setSmallDamage(double power): Le restan a la unidad el daño correspondiente según el poder del item atacante.<br />
<br />

* void counterAttack(IUnit unit): Realiza en contraataque cuando la unidad recibe un ataque, mandando un mensaje al item para que este ataque siempre que se pueda, es decir, que la unidad tenga item equipado, que la unidad atacante esté dentro del rango del item, que a la unidad atacada le quede vida.<br />
<br />

* void attack(IUnit unit): Realiza el ataque inicial, mandando un mensaje al item para que este ataque, con las mismas condiciones, añadiendo que la unidad objetivo aún tenga vida. Al final se llama a counterAttack de la unidad atacada.<br />
<br />

* void healedByStadff(Staff staff): Es el unico distinto entre los "Ataques" ya que acá no se envía un mensaje al item, si no que directamente se cambian los puntos de vida de la unidad como corresponda según el poder del Staff.<br />
<br />

En la clase abstracta se implementan la mayoría de los metodos ya explicados, se le dará especial atención a los equip... ya que en la clase abstracta se encuentran todos vacíos ya que las Unidades pueden equiparse solo unos Items especificos (no todos), por lo tanto cada Unidad va a realizar Override del metodo que le corresponda y los metodos que sean para equiparse Items que no puede equiparse va a heredarlos vacíos (no se lo equipa, no hace nada) <br />
<br />
Cada unidad realiza un Override al/los equip que correspondan (de los items que puedan equiparse) y se lo equipa siempre y cuando este se encuentre en su inventario.<br />
<br />
El cleric además hace override al metodo attack, para indicar no puede "atacar" si una unidad tiene la vida llena (ya que trataría de darle más vida que su máximo) y no realiza contraataque.<br />
<br />
La otra excepción es la Alpaca que le hace Override a recieveObj, ya que esta no tiene un limite de objetos que puede poner en su inventario.<br />
<br />

### **El mapa:**<br />
<br />
Por último el mapa esta conformado por la clase Field que posee los siguientes metodos:<br />
<br />

* void addCells(boolean connectAll, Location...cells): Añade celdas al mapa.<br />
<br />

* Location[] getAdjacentCells(Location cell): Entrega la/las celdas adjacentes a la actual.<br />
<br />

* void addConnection(Location cell1, Location ell2): Crea una conección entre esas celdas.<br />
<br />

* Location getCell(int row, int col): Entrega la celda con esas coordenadas.<br />
<br />

* Map<String,Location> getMap(): Entrega una copia del mapa.<br />
<br />

* boolean is Connected(): Verifica si el mapa esta conectado.<br />
<br />

* void removeConnection(Location cell1,Location cell2): Elimina la conección entre esas dos celdas.<br />
<br />

* boolean checkConnection(Location cell1,Location cell2): Revisa si dos celdas estan conectadas o no.<br />
<br />
En la clase Location tenemos:<br />
<br />

* boolean equals(Object obj): Hace Override al equals de la clase Object y compara si dos celdas son iguales comparando sus coordenadas.<br />
<br />

* void addNeighbour(Location neighbour)/void addTo(Location location)/boolean isNeighbour(Location otherLocation)/void removeNeighbour: Le añade un vecino a esta celda/añade esta celda como vecino/pregunta si tal celda es vecina de esta/elimina una celda como vecina de esta.<br />
<br />

* Set<Location> getNeighbours(): Entrega una copia de los vecinos de esa celda.<br />
<br />

* IUnit getUnit()/void setUnit()/void removeUnit(): Entrega la unidad en esa celda/Asigna una unidad a una celda/saca una unidad de esta celda.<br />
<br />

* double distanceTo(Location OtherNode): Entrega la distancia entre las dos celdas.<br />
<br />

* double shortestPathTo(Location otherNode,Set<Location> visited): Entrega el camino más corto para llegar la otra celda.<br />
<br />
Estos dos últimos metodos son muy útiles para ver las condiciones de ataque, de intercambio, entre otros.<br />
<br />
En los tests se utiliza la misma distribución de interfaces y clases abstractas, en donde se testea cada uno de los metodos que poseen los Items, las Unidades y el Mapa.
<br />
Lo último a explicar, que es importante comprender, es el Double Dispatch aplicado en los metodos de ataque:<br />
<br />
Primero si una unidad ataca a otra llama al metodo attack, el que manda un mensaje (attackWith) al Item que tenga esta unidad equipada para que el se encargue del trabajo (La unidad no tiene porque saber que item tiene equipado para realizar el ataque).<br />
<br />
Luego, el item le manda un mensaje a la unidad atacada para que esta decida que hacer al respecto (attackedBy), y la unidad atacada le envia un mensaje a su item con el arma que los está atacando, para que este (que sabe que tipo de item es) diga cuanto daño recibieron, y le indica devuelta a la unidad que tipo de daño recibió (setSmallDamage/setBigDamage/setNormalDamage).<br />
<br />
A continuación se explicarán los metodos, clases, interfaces, y la funcionalidad en general de este proyecto que parezca necesario explicar del Controller y del Tactician:<br />
<br />

### **El Controller:** <br />
<br />
El controller posee los siguientes metodos:<br />
<br />

* List<Tactician> getTacticians(): Devuelve los todos los tacticians independiente de si han perdido o no.<br />
<br />
 
* void setTacticians(): Resetea los tacticians para jugar una nueva partida (devuelve a todos los que habían perdido a que esten en juego nuevamente)<br />
<br />

* void setTacticiansObservers(): Añade los Observers a los tacticians para que estos puedan manejar los cambios que les corresponden (Cuando muere una unidad y cuando muere un Hero)<br />
<br />

* void setTacticianFields(): Le manda un mensaje a los tacticians indicandole cual es el mapa del juego para que estos guarden una referencia a el.<br />
<br />

* void setGameMap(): Crea aleatoreamente el mapa del juego.<br />
<br />

* void setSeed(long seed): Establece una seed que se usará en el mapa del juego y en la elección de turnos en la partida.<br />
<br />

* Field getGameMap(): Entrega el mapa del juego.<br />
<br />

* Tactician getTurnOwner(): Entrega al tactician que se encuentra en su turno en la partida.<br />
<br />

* List<Tactician> getCurrentOrder(): Entrega el orden en que deben jugar los tacticians en la ronda actual.<br />
<br />
 
* int getRoundNumber(): Entrega el número de ronda en que va la partida.<br />
<br />

* int getMaxRounds(): Entrega el número máximo de rondas de esta partida, si se alcanza este número de rondas la partida debe terminar.<br />
<br />

* void newRound(): Comienza una nueva ronda.<br />
<br />

* void reorderTurns(): Reordena los turnos para la siguiente ronda, no permitiendo que un jugador tenga dos turnos seguidos.<br />
<br />

* void startTurn(Tactician tactician): Comienza el turno del tactician entregado.<br />
<br />

* void endTurn(): Termina el turno del tactician que se encontraba actualmente jugando e inicia el turno del siguiente, si este era el último tactician de la ronda comienza una nueva.<br />
<br />

* void removeTactician(): Elimina al tactician de la lista de tacticians en juego, y elimina todas sus unidades retirandolas también del mapa.<br />
<br />

* void resetGame(): Devuelve todos las variables del juego a sus valores iniciales, como por ejemplo el número de la ronda actual vuelve a 0, si murió algún tactician este regresa a la lista de tacticians en juego, entre otros.<br />
<br />

* void initGame(int rondas): Inicia un juego con el número máximo de rondas entregado.<br />
<br />

* void initEndlessGame(): Inicia un juego sin número máximo de rondas.<br />
<br />

* List<String> getWinners(): Entrega una lista con los nombres de los tacticians que ganaron, esta lista va a ser distinta de null solo si: En un juego con máximo de rondas llegamos al final de las rondas, en donde serán ganadores los que sigan en pie y tengan más unidades vivas. En un juego sin máximo de rondas es ganador el último tactician en pie.<br />
<br />
 
* IUnit getSelectedUnit(): Entrega la unidad que se encuentra seleccionada en estos momentos.<br />
<br />

* void selectUnitIn(int x, int y): Selecciona la unidad que se encuentra en las coordenadas provistas.<br />
<br />

* List<IEquipableItem> getItems(): Entrega la lista de items de la unidad seleccionada, si no hay unidad seleccionada no entrega nada.<br />
<br />
 
* void equipItem(int index): Equipa el item que se encuentra en ese indice del inventario de la unidad seleccionada, si no hay unidad seleccionada no equipa nada.<br />
<br />

* void useItemOn(int x, int y): Usa el item de la unidad seleccionada y lo usa en la unidad que se encuentra en las coordenadas provistas, luego checkea si alguna de las dos unidades murió para evaluar si el tactician de la unidad muerta ha perdido el juego o no.<br />
<br />

* void selectItem(int index): Seleccionae el item que se encuentra en ese indice del inventario de la unidad seleccionada.<br />
<br />

* IEquipableItem getSelectedItem(): Entrega el item que se encuentra seleccionada en estos momentos.<br />
<br />

* void giveItemTo(int x, int y): Le da a la unidad que se encuentra en las coordenadas provistas el item que está actualmente seleccionado.<br />
<br />

Luego se encuentran los metodos para añadir unidades a los diferentes tactician, para cada unidad hay un método distinto, a todos se les debe ingresar el tactician a cual se le quiere añadir la unidad.<br />
<br />

* void putUnitsOn(Tactician tactician, List<Location> locations): Posiciona todas las unidades del tactician en la lista de ubicaciones entregadas. Deben calzar las dimensiones de la lista de unidades del tactician con las de la lista de ubicaciones entregadas.<br />
<br />
 
Luego vienen los metodos para añadir items a las distintas unidades de los tactician, para cada item hay un método distinto. El item se añade al tactician que se encuentra en su turno y se debe ingresar la posición en la lista de unidades del tactician de la unidad a la que se le quiere añadir el item.<br />
<br />

* void moveTo(int x, int y): Mueve a la unidad seleccionada a las coordenadas provistas.<br />
<br />
 
### **El Tactician:**<br />
<br />

El tactician posee los siguientes metodos:<br />
<br />

* String getName(): Entrega el nombre del tactician.<br />
<br />

* List<IUnit> getGlobalUnits(): Entrega la lista de unidades del tactician, esta consiste en todas las unidades independiente de si estas estan vivas o muertas en la partida actual, puede entenderse como si fuera el alma de las unidades.<br />
<br />
 
* List<IUnit> getUnits(): Entrega la lista de unidades del tactician que se encuentran vivas en la partida actual, puede entenderse como si fuera el cuerpo de las unidades.<br />
<br />
 
* void addDeadHeroObserver(DeadHeroHandler resp): Suscribe al Observer encargado de comprobar la muerte del Hero a este tactician.<br />
<br />

* void setDeadHero(): Le avisa al observer que se le ha muerto el Hero a este tactician, entregando como nuevo valor al tactician para que el observer pueda realizar las acciones necesarias con el.<br />
<br />

* void addDeadUnitObserver(DeadUnitHandler resp): Suscribe al Observer encargado de comprobar la muerte de una unidad a este tactician.<br />
<br />

* void setDeadUnit(): Le avisa al observer que se le ha muerto una unidad a este tactician, entregando como nuevo valor al tactician para que el observer pueda realizar las acciones necesarias con el.<br />
<br />

* void addUnit(IUnit unit): Añade una unit a la lista de units globales del tactician, inicializando que esta aún no se ha movido (ya que solo se pueden mover una vez por turno).<br />
<br />

* void restoreUnits(): Cura a las unidades que hayan sido dañadas y devuelve a la vida a las que hayan muerto para comenzar una nueva partida.<br />
<br />

* void restoreMovement(): Devuelve a falso el indicador de si una unidad se ha movido o no para todas las unidades del tactician.<br />
<br />

* List<Pair> getLocations(): Entrega una lista con los pares de coordenadas en donde estan ubicadas cada una de las unidades del tactician.<br />
<br />
 
* void eraseLocations(): Elimina las locations de las unidades del tactician, vuelve la lista una lista vacía.<br />
<br />

* void setLocations(Location location): Transforma la location entregada en un par de coordenadas y la añade a la lista de locations del tactician.<br />
<br />

* List<Boolean> getMovedUnit(): Entrega la lista que indica si las unidades se han movido o no este turno.<br />
<br />
 
* void setMovedUnit(int index): Cambia el valor que corresponde en la lista de movimiento de las unidades indicando que la unidad que se encuentra en el indice entregado ya se ha movido.<br />
<br />

* void removeUnit(IUnit unit): Remueve la unidad entregada de la lista de unidades vivas.<br />
<br />

* void setMapField(Field map): Establece que el mapa en el que esta jugando el tactician es el mapa entregado. <br />
<br />

* Field getMapField(): Entrega el mapa en el que esta jugando el tactician. <br />
<br />

* void checkUnits(): Revisa si se ha muerto alguna unidad del tactician y si es así, revisa si es un Hero o no para llamar al metodo correspondiente que informe al observer de la situación. <br />
<br />
 
### **El DeadUnitHandler:**<br />
<br />
El dead unit handler posee el siguiente metodo:<br />
<br />

* void propertyChange(PropertyChangeEvent evt): Remueve la unidad que se le murió al tactician y si esta era su última unidad llama al metodo del controller que remueve al tactician del juego.<br />
<br />

### **El DeadHeroHandler:**<br />
<br />
El dead hero handler posee el siguiente metodo:<br />
<br />

* void propertyChange(PropertyChangeEvent evt): Llama al metodo del controller que remueve un tactician para que remueva al tactician al que se le murió el hero.<br />
<br />

## :beginner: **Información extra**
No deberían crearse Items con el mismo nombre, ya que eso podría provocar problemas en la comparación de Items (2 Items se consideran iguales sin su poder, sus rangos y su nombre son iguales)<br />
<br />
Algunos tests toman mucho tiempo debido al tamaño del mapa, pero estos efectivamente funcionan, por lo que se decidió crear un mapa más pequeño para estos tests, si desea probarlos con el mismo tamaño de mapa que el resto de los test, debe comentar las primeras dos lineas del test que crean un controller con tamaño de mapa 3 y setea el mapa.<br />
<br />
En el modelo el metodo getTactician original devolvía los tacticians actualmente en juego y lo cambié a que devuelva todos los tacticians, independiente de si este ha perdido o no. Y en sustitución, el metodo getCurrentOrder devuelve los tacticians que se encuentra actualmente en juego.<br />
<br />
Hay un error conocido: A veces el test que verifica el orden de los tacticians falla debido a que no se setea correctamente la seed, considero esto un error fuera de mi alcance ya que más alla que decirle a la seed que se setee no hay mucho más que pueda hacer para asegurarme que realmente lo haga. Pero independiente de eso con otros test se puede apreciar que en cada ronda los turnos cambian correctamente.<br />
<br />
Se deben hacer correcciones en el modelo:<br />
<br />
Se deben implementar interfaces que diferencien los items que realizan ataques y los que no, ya que de esta manera se evita código duplicado y se logra desambiguar aún más los metodos de ataque, permitiendo que los item que no tengan la capacidad de atacar no tengan que poseer un metodo ataque vacío, teniendo más claridad en el código (si items que no atacan tienen un metodo para atacar puede causasr confusión a alguien que quiera usar el código).<br />
Información de contacto:  <br />
<br />
Mail: BeaGraboloza@gmail.com<br />
<br />
Usuario de GitHub: BeaNyann<br />
<br />
Instagram: Bea_Nyan<br />
<br />
