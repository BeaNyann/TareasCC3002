# TareasCC3002 : Alpaca Emblem

## :beginner: **Introducción**

Alpaca Emblem consiste en un juego de estrategia por turnos con distintos tipos de unidades que tienen fortalezas y debilidades entre ellas. 

## :beginner: **Información del proyecto**

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
Y luego de un ataque, siempre que pueda, la unidad víctima va a realizar un contraataque.

## :beginner: **Documentación**

El juego actualmente no posee forma de ejecutarse, pero se ha comprobado la funcionalidad de todos sus metodos a travez de múltiples tests.<br />
<br />
Para descargarlo debes clonar este repositorio en tu propio computador y ejecutarlo en alguna IDE que reconozca el lenguaje JAVA.<br />
<br />
A continuación se explicarán los metodos, clases, interfaces, y la funcionalidad en general de este proyecto que parezca necesario explicar:<br />
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
Luego, el item le manda un mensaje a la unidad atacada para que esta decida que hacer al respecto (attackedBy), y la unidad atacada le envia un mensaje a su item con el arma que los está atacando, para que este (que sabe que tipo de item es) diga cuanto daño recibieron, y le indica devuelta a la unidad que tipo de daño recibió (setSmallDamage/setBigDamage/setNormalDamage).

## :beginner: **Información extra**
No deberían crearse Items con el mismo nombre, ya que eso podría provocar problemas en la comparación de Items (2 Items se consideran iguales sin su poder, sus rangos y su nombre son iguales)<br />
<br />
Información de contacto:  <br />
<br />
Mail: BeaGraboloza@gmail.com<br />
<br />
Usuario de GitHub: BeaNyann<br />
<br />
Instagram: Bea_Nyan<br />
<br />
