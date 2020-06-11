# Tic Tac Toe *eli* Ristinolla

Pelaa ristinollaa tekoälyä vastaan ja kehitä pelistrategiaasi. Ohjelman tekoäly on toteutettu perinteisellä minimax-algoritmilla käyttäen lisäksi ohjelmaa tehostavaa alfa-beeta-karsintaa.

## Pelin säännöt

Pelissä on kaksi pelaajaa - risti ja nolla. Peliruudukko on perinteisesti 3x3 -kokoinen, mutta tässä pelissä saat itse valita peliruudukon koon välillä 2-10 (niin, että ruutuja on aina yhtä monta horisontaalisesti ja vertikaalisesti). Toinen pelaaja aloittaa sijoittamalla oman merkkinsä (risti tai nolla) johonkin ruutuun. Sen jälkeen on toisen vuoro ja hän tekee samoin, mutta ei voi asettaa merkkiään jo käytössä olevaan ruutuun. Voittaja on se, joka ensimmäisenä saa kokonaisen rivin omia merkkejä joko vaaka-, pysty- tai vinoriville. Perinteisessä 3x3 -ruudukossa voittorivi on pituudeltaan 3, mutta tässä pelissä sekin on pelaajan määriteltävissä välillä 2-10 - kunhan voittorivi ei ole ruudukkoa suurempi.

![alt_text](https://media3.giphy.com/media/l1Et6k00qp9fMTP8s/giphy.gif?cid=ecf05e475bd1d54dd29a0664dee9e7f5ada4ca018d106a9d&rid=giphy.gif)

## Dokumentaatio

[Määrittelydokumentti](https://github.com/puuro-maria/TicTacToe/blob/master/dokumentaatio/maarittelydokumentti.md)

[Työaikakirjanpito](https://github.com/puuro-maria/TicTacToe/blob/master/dokumentaatio/viikkoraportit/tyoaikakirjanpito.md)

[Testausdokumentti](https://github.com/puuro-maria/TicTacToe/blob/master/dokumentaatio/testausdokumentti.md)

## Viikkoraportit

[Viikon 4 raportti](https://github.com/puuro-maria/TicTacToe/blob/master/dokumentaatio/viikkoraportit/viikko4.md)

[Viikon 3 raportti](https://github.com/puuro-maria/TicTacToe/blob/master/dokumentaatio/viikkoraportit/viikko3.md)

[Viikon 2 raportti](https://github.com/puuro-maria/TicTacToe/blob/master/dokumentaatio/viikkoraportit/viikko2.md)

[Viikon 1 raportti](https://github.com/puuro-maria/TicTacToe/blob/master/dokumentaatio/viikkoraportit/viikko1.md)

## Komentorivitoiminnot

Lataa pakkaus omalle koneelle:

```
git clone https://github.com/puuro-maria/TicTacToe

cd TicTacToe/TicTacToe
```

Luo jar-tiedosto:

```
mvn package
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
