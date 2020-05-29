# Viikkoraportti 3

![alt_text](https://media3.giphy.com/media/VMtTNzgBjvlHG/giphy.gif?cid=ecf05e47b6815608319eecdfa32381fa9378c9088f9e8074&rid=giphy.gif)

## Mitä olen tehnyt tällä viikolla?

Tällä viikolla olen koodannut ohjelmaan metodin, joka tarkistaa voittajan. 
Metodi oli yllättävän työläs pohtia ja tehdä, eikä se ole vielä täysin valmis. 
Se ei vielä toimi, mikäli haluttaisiin itse määritellä voittorivin pituus (esim 10x10 ruudukko, mutta voittoriviin vaaditaan 6 peräkkäistä merkkiä).
Se ei myöskään täysin toimi ristikkomatriisin diagonaaleissa (toimii vain vasemmalta oikealle), se täytyy korjata ensi viikolla.
Olen kirjoittanut myös pari muuta metodia, mm. ristikon tulostusmetodin tekstikäyttöliittymää varten sekä metodin, joka hakee koordinaatteina vapaat paikat.
Laadin myös luomilleni metodeille testit, jotta testikattavuus pysyy ajan tasalla.
Muutin enum-taulukon int-taulukoksi ohjelman tehostamiseksi.

## Miten ohjelma on edistynyt?

Ohjelma on sikäli edistynyt, että se sisältää nyt melko hyvin ristinollan pääsäännöt ja pystyy tarkistamaan, milloin toinen on voittanut.
Ohjelma myös tuottaa listan vapaista paikoista muodossa String[]. Pääohjelma testaa paria ominaisuutta. 

### Testikattavuustilanne 29.5.2020:

![alt_text](https://github.com/puuro-maria/TicTacToe/blob/master/dokumentaatio/kuvat/jacoco_vk3.png)

## Mitä opin tällä viikolla?

Tällä viikolla ei koettu suuria valaistumisia, mutta ohjelman rakenne tarkentui itselle jälleen. 
Opin, että ensi viikolla voisin tehdä hommia jo hieman aiemminkin.

## Mitä jäi epäselväksi?

Jäin miettimään, onko String[] paras tapa säilöä mahdolliset siirrot, mutta ilmeisesti kuitenkaan Javan valmiita listarakenteita ei saa käyttää.
Mietin myös, miten muokkaan checkWinner -metodia siten, että se ymmärtää etsiä tarpeeksi pitkiä substringeja mikäli pelaaja on asettanut voittorivin pituuden lyhyemmäksi kuin rivi- ja sarakepituuden.
Tämän tyyppisiä ratkaisuja on kyllä muistaakseni opetettu TiRa-kurssilla, eikä pitäisi olla kamalan vaikea tehtävä jos vain kertaa.

## Mitä teen seuraavaksi?

Seuraavaksi korjaan chechWinner-metodin ja sitten koodaan AI-luokkaa.
AI-luokassa voi algoritmin helppoudesta huolimatta tulla kysymyksiä, joten se on hyvä aloittaa pikimmiten.
Controls-luokkaa (sovelluslogiikkaa) tuskin on kovin järkevää alkaa rakentamaan ennen kuin vastapeluri on valmis. 
