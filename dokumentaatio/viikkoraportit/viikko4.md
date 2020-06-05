# Viikon 4 raportti

![alt_text](https://media0.giphy.com/media/xiAqCzbB3eZvG/giphy.gif?cid=ecf05e478ca5d1b03b7db6fa3afc89fad2ce5b9ccebf64b5&rid=giphy.gif)

## Mitä olen tehnyt tällä viikolla?

Tällä viikolla olen saanut aikaiseksi tekstikäyttöliittymän ja sovelluslogiikan pääosin. 
Peli ei vielä*kään* ota voittorivin merkkimäärää parametrina, eikä käy läpi voittomatriisin diagonaalia oikealta vasemmalle.
Eli käytännössä toistaiseksi voittorivi on aina yhtäsuuri kuin ruudukon sivut.
Olen myös saanut tehtyä minimax-algoritmin pohjan, mutta se ei vielä tee täysin älykkäitä päätöksiä sillä se on vielä melko helppo voittaa.
En tiedä johtuuko tämä siitä, että siinä on syvyysrajoitus ja alfa-beeta-karsinta ei ole vielä käytössä.
On myös hyvin mahdollista, että minulta on livahtanut sinne jokin virhe - täytyy tutkia asiaa taas lähipäivinä.

## Miten ohjelma on edistynyt?

Peli on nyt pelattavissa, joskin vielä helppo voittaa. Alfa-beeta-karsinnan puutteen vuoksi yli 4x4 -kokoista ruudukkoa ei kannata luoda.
JavaDoc- ja testikattavuuspuoli on jäänyt tällä viikolla pienelle huomiolle, mutta asia tullaan korjaamaan ensi viikon aikana. 

## Mitä opin tällä viikolla?

Minimax-algoritmin kirjoittaminen Javalla ja ristinollaan sovellettuna on yllättävän työlästä - ainakin kun ruudukon koko on määriteltävissä itse. 
Ajatusvirheitä sattuu hämmästyttävän helposti. 
Minimax-ristinolla on myös toteutettavissa hyvin vaihtelevin tavoin, minkä huomasin tutkiessani Github-repoja ja netin pseudokoodiesityksiä.

## Mitä jäi epäselväksi?

En ymmärrä, miksi minimax tekee vieläkin vähän tyhmiä ratkaisuja, vaikka ruudukon koko olisikin vain 3x3. 
Täytyy tarkastella koodia uudelleen kun saa ajatuksia selkiytettyä.

## Mitä teen seuraavaksi?

Aion saada minimaxin toimimaan ja lisätä ohjelmaan alfa-beta-karsinnan. 
Lisäksi tarkoitus olisi saada voittolinjat toimimaan kunnolla. Dokumentoinnissa ja testikattavuudessa on vielä myös paljon parannettavaa.
