# Käyttöohjeet

## Sovelluksen asentaminen ja käynnistäminen

Käytössä on Maven-työkalu. Javan versio 11. 

### Komentorivitoiminnot

Lataa pakkaus omalle koneelle:

```
git clone https://github.com/puuro-maria/TicTacToe

cd TicTacToe/TicTacToe
```

Luo jar-tiedosto:

```
mvn package
```

Jar-tiedosto löytyy projektin juuresta kansiosta **target** nimellä TicTacToe-1.0-SNAPSHOT.jar. Tiedoston nimi on hyvä muuttaa.
Valmis jar-tiedosto löytyy myös [täältä](https://github.com/puuro-maria/TicTacToe/releases/tag/Final).

Aja jar-tiedosto (target-kansiossa):

```
java -jar TicTacToe-1.0-SNAPSHOT.jar
```

Aja testit:

 ```
 mvn test
 ```
 
 Testikattavuusraportti (JaCoCo):
 
 ```
 mvn jacoco:report
```

Checkstyle-raportti:

```
mvn jxr:jxr checkstyle:checkstyle
```


## Pelaaminen

Pelissä on yksinkertainen tekstikäyttöliittymä.

- Aloita pelaaminen ajamalla ohjelma.

- Peli kysyy sinulta, kuinka suuren peliristikon haluat - syötä kokonaisluku, jolloin peliristikosta tulee NxN kokoinen.

![alt_text](https://github.com/puuro-maria/TicTacToe/blob/master/dokumentaatio/kuvat/TTT_ohjekuva1.PNG)

- Peli kysyy sinulta, kuinka pitkän voittorivin haluat. Syötä kokonaisluku. Voittorivi ei voi olla pidempi kuin yllä syötetty N.

- Peli alkaa - AI aloittaa ristillä. *Voit myös pienellä muokkauksella UI-luokassa asettaa itsesi aloittajaksi.*

- Kun AI on asettanut ristin ruutuun, on sinun vuorosi. Syötä koordinaatit muodossa x,y eli esimerkiksi 1,1. Ensimmäinen rivi ja sarake on 0. 

![alt_text](https://github.com/puuro-maria/TicTacToe/blob/master/dokumentaatio/kuvat/TTT_ohjekuva2.PNG)

- Jatka peliä kunnes se päättyy tasapeliin tai toisen voittoon. Jos päädyt 3x3 -ruudukon pelissä AI:n voittoon, olet tehnyt jotain väärin.
