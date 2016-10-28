# Regist
Android Beadando

A beadandó egy regisztrációról szól, ami tartalmaz TextField, RadioButton, Button, SwitchButton és Spinner Input Controllert.

A TextFieldek minden helyen a mellette megadott adatot várják, ha a bevitt adatt üres vagy nem teljesítő a megfelelő hosszat egy hibával
tér vissza a TextField, ha az adat megfelelő átküldi az adatot a második Activitynek.

(isChecked)Két RadioButton található meg a projectben ami el van helyezve egy RadioGroup-ban.A megfelelő nem kiválasztásával egy String változónak
az értékét módosítja a nem-re és átküldi a második activitynek majd megjelenítésre kerül.

(onClick)Az első Activityn található Button a Register metódust hívja meg ami megvizsgálja az adatokat hogy tartalmaznak-e hibát, hiba esetén 
hibaüzenetet ad vissza a hibás mező mellett.Hibátlan adatok kitöltése esetén továbblép egy RegisterSuccess metódusba ahol a kitöltött
adatokat átküldi a második Activitynek és egyben megnyitja a második Activityt.
A második Activityben található Button pedig bezárja az Activityt és visszatér az első Activityre ahol a kitöltött adatokat törli.

(onCheckedChanged)A Switchbutton segítségével beállíthatjuk hogy szeretnénk-e értesítéseket kapni a felhasználónkra.Az ON és az OFF érték esetén
egy String változóban eltárolja a beállítás megnevezését és továbbküldi a RegisterSuccess metódusban a második Activitynek.

(onItemSelected)A spinner segítségével kiválaszthatjuk a tartózkodási helyünket, ami kilistázza a country_names nevű tömb elemeit és ezek közül lenyitva
a spinnert választhatunk.A kiválasztott adatot szintén egy String változóba helyezzük a tömbön belüli poziciónak egy értékét megadva.

