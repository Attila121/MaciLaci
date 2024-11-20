# Maci Laci

A fájlokat letöltve, a `dist` mappában lévő `.jar` fájlal a játék futtatható.

## A feladat:

A meséből jól ismert Maci Laci bőrébe bújva a Yellowstone Nemzeti Park megmászhatatlan hegyei és fái között szeretnénk begyűjteni az összes rendelkezésre álló piknik kosarat. Az átjárhatatlan akadályok mellett Yogi élelem szerzését vadőrök nehezítik, akik vízszintesen vagy függőlegesen járőröznek a parkban. 

Amennyiben Yogi egy egység távolságon belül a vadőr látószögébe kerül, úgy elveszít egy élet pontot. *(Az egység meghatározása rád van bízva, de legalább a Yogi sprite-od szélessége legyen.)* Ha a 3 élet pontja még nem fogyott el, úgy a park bejáratához kerül, ahonnan indult.

A kalandozás során számon tartjuk, hogy hány piknik kosarat sikerült összegyűjtenie Lacinak. Amennyiben egy pályán sikerül összegyűjteni az összes kosarat, úgy töltsünk be, vagy generáljunk egy új játékteret. Abban az esetben, ha elveszítjük a 3 élet pontunkat, úgy jelenjen meg egy felugró ablak, melyben a nevüket megadva el tudják menteni az aktuális eredményüket az adatbázisba. Legyen egy menüpont, ahol a 10 legjobb eredménnyel rendelkező játékost lehet megtekinteni az elért pontszámukkal, továbbá lehessen bármikor új játékot indítani egy másik menüből.

---

## Megoldás terve:

- A `JPanel` használatával kirajzoltatjuk a képernyőre a menüt, amiben a `W` és `S` gombokkal tudunk navigálni a menüpontok között.
- Ha az új játék menüpontot választjuk, akkor kirajzoljuk az első pályát a karakterünkkel és a többi sprite-al együtt. 
  - Itt a `W`, `A`, `S`, `D` billentyűkkel tudjuk a karakterünket mozgatni.
- A fa és hegy sprite-okat vizsgáljuk, hogyha beléjük ütközünk, akkor megállítjuk a mozgást abban az irányban, amerre az ütközés történik.
- Ha a szereplő egy kosárral ütközik, akkor:
  - Megnövelődik a pontszámláló.
  - A kosár eltűnik.
- Ha egy ranger-rel ütközünk:
  - Elvesztünk egy életpontot.
- A játéknak akkor lesz vége, ha:
  1. Nincs már több életpontunk.
  2. Az összes pályán az összes kosarat felvettük.

---

## Osztályok leírása:

### `Entity`
Ez az osztály segít megvalósítani számunkra a `Ranger` és `Player` osztályokat.

### `Player`
A fő karaktert valósítjuk meg vele. Úgy implementáljuk, hogy a különböző gombok lenyomására a megfelelő irányban forduljon a kirajzolt karakter, és a meghatározott sebességgel haladjon is el.  
Megvizsgáljuk a különböző ütközéseket is, és a típusuk alapján a megfelelő reakciót váltjuk ki.

### `Ranger`
A ranger karakterek kirajzolására és azok mozgatására szolgáló osztály.

### `AssetSetter`
Ebben az osztályban példányosítjuk a ranger és basket objektumokat.

### `CollisionChecker`
Az ebben található metódusokkal ellenőrizzük az ütközéseket különböző típusok alapján.

### `DataBase`
Az adatbázishoz csatlakozás, illetve az olvasás és az írás itt valósul meg.

### `GamePanel`
Ez az osztály a `JPanel` leszármazottja. Ebben rajzoljuk, illetve futtatjuk a játékot a `Runnable` megvalósításával. Így egy futtatható állományt hozunk létre, amelyet beállítunk 60 FPS-re, ami azt jelenti, hogy a képet másodpercenként 60-szor frissítjük.

### `KeyHandler`
Ebben az osztályban vizsgáljuk meg a gomblenyomásokat.

### `Result`
Ilyen formátumban kapjuk meg az eredményeinket, amiket az adatbázisban tárolunk.

### `UI`
A `UI` segít a játék felhasználói felületének implementálásában. Ebben jelenítjük meg a menüt, és a játék közben kiírt felületeket is ennek az osztálynak a segítségével hozzuk létre.

### `TileManager`
Ebben az osztályban olvassuk be egy fájlból a játékteret.
