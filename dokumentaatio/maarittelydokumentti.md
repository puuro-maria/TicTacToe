# Sovelluksen määrittelydokumentti :pencil2:

Sovellus on laajennettu ristinollapeli, jossa pelaaja saa valita ristikon koon ja voittorivin pituuden.
Ristinollaa pelataan "tekoälyä" vastaan. Tekoäly on toteutettu minimax-algoritmilla hyödyntäen alfa-beeta-karsintaa tehokkuuden maksimointiin.
Sovellus toteutetaan Javalla, käytössä Javan versio 11. 

### Miksi valitsin tämän aiheen?

Aihe oli yksi kurssin aihe-ehdotuksista ja ajattelin, että haluaisin kokeilla, osaisinko luoda pienen "tekoälypelin". 
Ajattelin minimaxin olevan yksinkertainen algoritmi - niin kuin se sellaisenaan onkin.
Vaikka en juurikaan pelien ohjelmoinnista ole kiinnostunut, on sitäkin hyvä kokeilla. 
Ohjelman toteuttaminen kuitenkin osoittautui haasteeksi, mutta loppupeleissä oli hauskaa.

## Minimax-algoritmi 

Pelin tekoäly tullaan toteuttamaan perinteisellä minimax-algoritmilla.
Minimax-algoritmi on peruuttavaan hakuun perustuva rekursiivinen algoritmi, joka arvioi vuorottain pelattavan pelin skenaariot tiettyyn syvyyteen asti.
Minimaxin toimintaa on hyvä havainnollistaa puuna, jossa jokainen kerros on toisen pelaajan vuoro ja jokainen solmu on yksi siirto pelissä.
Puun kerrokset edustavat vuorotellen joko maksimoivan tai minimoivan pelaajan vuoroa. 
Maksimoivan pelaajan näkökulmasta algoritmi arvioi, että minimoiva pelaaja haluaa aina minimoida algoritmin lopputuloksen voittaakseen.
Maksimoiva pelaaja pyrkii saavuttamaan mahdollisimman suuren lopputuloksen (tässä tilanteessa 1). 
Tekoäly olettaa, että vastapeluri pyrkii aina valitsemaan vastustajansa kannalta huonoimman skenaarion. 
Jokaisen puun lehdissä on joko arvo 1, -1 tai 0 riippuen kyseisen skenaarion lopputulemasta.
*Lopullisessa toteutuksessa lehden arvo on kyseiselle peliristikon ruudulle laskettu positioarvo, tästä lisää toteutusdokumentissa*.
Alla näkyvässä yksinkertaistuksessa; jos lehden arvo on 1, maksimoiva pelaaja voittaa, -1 jos minimoiva pelaaja voittaa ja tasapelin tullessa 0. 

### Minimax-puu havainnollistettuna

![alt_text](https://github.com/puuro-maria/TicTacToe/blob/master/dokumentaatio/kuvat/minimaxpuu.PNG)

### Alfa-beeta-karsinta

Minimax käy sellaisenaan läpi (syvyysrajan salliessa) pelin joka ikisen lopputuleman - tämä vie paljon aikaa. 
Alfa-beeta-karsinta on minimaxiin tarkoitettu tehostuslisä, jossa kunkin pelaajan kannalta ei-rationaaliset skenaariot jätetään jo alkuunsa huomioimatta, eikä sitä puuta siis tutkita rekursiossa enempää. 
Tämä tehostaa minimaxia merkittävästi, kuten toteutusdokumentissa taulukoiduissa nopeustesteissä todistetaan.

### Minimax ja alfa-beeta-karsinta pseudokoodina :triangular_ruler:

*Ensimmäisessä kutsussa alpha on -Infinity ja beta on Infinity*
```
function miniMax(node, depth, maxPlayer, alpha, beta) { 
  if maxPlayer {
    bestValue = -Infinity
    for each child in node {
      value = miniMax(child, depth - 1, false, alpha, beta)
      bestValue = max(value, bestValue)
      alpha = max(bestValue, alpha)
      if beta <= alpha
          break
      return bestValue
    }
  } else {
    value = Infinity;
    bestValue = Infinity
    for each child in node {
      value = miniMax(child, depth - 1, true)
      bestValue = min(value, bestValue)
      beta = min(bestValue, beta)
      if beta <= alpha
          break
      return bestValue
    }
  }
}
```

**Node** edustaa tässä ohjelmassa aina pelitaulukkoa kussakin vaiheessa peliä. 
Minimaxille annetaan siis pelissä node-parametrina pelilauta (2D-taulukko) ja minimax käy kulloisenkin pelilaudan läpi yksi ruutu kerrallaan asettamalla siihen aina joko minimoivan tai maksimoivan pelaajan merkin ja kutsumalla jälleen minimaxia.

**MaxPlayer** on boolean-muuttuja, joka ilmoittaa algoritmille, täytyykö sen minimoida vai maksimoida tulos.
Rekursio tapahtuu kun halutaan selvittää, onko solmun lapsissa mahdollisesti suurempia tai pienempiä lopputulemia.
    
### Ohjelman bestMove-metodi selitettynä :bulb:

BestMove-metodi on se metodi ohjelmassa, joku kutsuu minimaxia. 
BestMove-metodi lähtee käymään peliristikkoa läpi yksi ruutu kerrallaan.
Ensin algoritmi sijoittaa ristin ruutuun i,j (siirto kumotaan bestMoven lopuksi, siirrot tapahtuvat Controls-luokassa) ja tarkistaa, onko tämä ruutu sellainen ruutu, jolla AI itse voittaa pelin välittömästi. 
Tämä tapahtuu kutsumalla Board-luokan positionValue-metodia, joka antaa kyseisen position optimaalisen arvon pelaajan näkökulmasta.
Jos voittoruutu löytyy, bestMove palauttaa koordinaatit.
Jos voittoruutua ei löydy, bestMove tarkistaa, onko kyseinen ruutu vastustajalle välitön voittoruutu. Tämä tapahtuu kutsumalla positionValue-metodia vastustajan parametreilla.
Jos tämä on välitön voittoruutu, bestPoints-arvoksi asetetaan korkea arvo - sellainen, että minimax ei löydä korkeampaa arvoa, mutta ohjelma jatkaa kuitenkin mahdollisen AI:n voittoruudun etsintää.
Minimaxia kutsutaan yllä olevien toimintojen jälkeen ja mikäli kumpikaan yllä olevista skenaarioista ei toteudu, palautetaan minimaxin löytämä paras arvo.
