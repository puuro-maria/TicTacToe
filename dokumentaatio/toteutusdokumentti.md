# Toteutusdokumentti :wrench:

## Ohjelman rakenne :house:

### Pakkausrakenne

Ohjelma on jaettu kolmeen eri pakkaukseen; **domain** sisältää tietorakenteet; pelilaudan ja Cell-olion, joka on joko risti tai nolla.
**Controls** -pakkaus sisältää sovelluslogiikan ja pelin tekoälyn eli minimax-algoritmin. **Ui** -pakkaus sisältää käyttöliittymän ja Main-luokan.

#### Pakkauskaavio

![alt_text](https://github.com/puuro-maria/TicTacToe/blob/master/dokumentaatio/TicTacToe_pakkauskaavio.PNG)

### Luokkarakenne

Domain-pakkauksessa oleva **Board**-luokka sisältää ristinollapelin ristikon ja ristikon voittosäännöt. 
Itse ristikko on tehokkuuden vuoksi toteutettu 2D-taulukkona (int[][]), jonka arvot ovat 0, 1 tai -1. 
Domain-pakkauksessa sijaitseva **Cell**-enum sisältää kategoriset muuttujat *CROSS*, *CIRCLE* ja *BLANK*.

Controls-pakkausessa oleva luokka **AI** sisältää minimax- ja alfa-beeta-karsinnan algoritmit. 
Minimax on esitetty pseudokoodina määrittelydokumentissa. 
Controls-luokka sisältää sovelluslogiikan, jotta käyttöliittymässä ei tarvitse kutsua useita eri luokkia ja käyttöliittymä on eriytetty hyvin tietorakenteista.

Ui-pakkaus sisältää tekstikäyttöliittymän ja main-luokan.

## Aikavaativuus :hourglass_flowing_sand:

### Minimax-algoritmin aikavaativuus

