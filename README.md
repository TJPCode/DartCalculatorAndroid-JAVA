# Tikanheiton pistelaskuri androidille – JAVA / XML

Työkalut: Android Studio 2.0, Samsung Galaxy S4.

--------------------------------------------

Sovellus on kehitetty Android Studiolla ja testattu emulaattorilla sekä Samsung Galaxy S4 -puhelimella. Paras yhteensopivuus on Androidin versiosta 4.4.4 (KitKat) alkaen.

Käyttäjä voi valita 25, 50, 125 tai 250 tikan sarjan. Sovellukseen syötetään jokaisella kierroksella viiden tikan pisteet ja sovellus laskee kierroksen yhteispisteet. Viimeisen kierroksen jälkeen sovellus näyttää kokonaispisteet. Sovelluksella on myös mahdollista luoda 25 tikan kisa, johon voi osallistua 2-4 heittäjää. 

--------------------------------------------
TIKKALASKURI

Kierros valmis -nappi on disabloitu kunnes kaikissa viidessä tikka-tekstikentässä on jokin numeroarvo. Kenttiin voi syöttää vain numeroita ja maksimissaan kaksi merkkiä. Napin painamisen jälkeen tikka-tekstikentät tyhjentyvät, nappi disabloituu ja ylhäällä oleva kierroksen kertova teksti päivittyy.

Nollaa-nappi tyhjentää kyseisen näkymän tiedot. Nappia painettaessa ilmestyy dialogi, jossa pyydetään vahvistamaan nollaus.

Tuloslistassa näytetään kierrosten heitot ja ne käännetään laskevaan järjestykseen eli kierroksen suurimman heiton arvo tulee ensimmäisenä. Kun viimeinen kierros tulee päätökseen, tekstikentät ja kierros valmis -nappi disabloidaan. Ylhäällä näytetään kokonaispisteet.

--------------------------------------------
KISA

Käyttäjä valitsee osallistujien määrän. Tekstikenttiä tulee ja poistuu näkyvistä riippuen radionapin valinnasta. Aloita-nappi enabloituu vasta kun kaikissa nimikentissä on tekstiä ja disabloituu, jos nimikentästä poistetaan teksti.

Aloita-nappi siirtää käyttäjän uuteen näkymään, jossa pidetään kirjaa kilpailun tilanteesta. Jokaisella kilpailijalla on oma osio ja niitä on näkyvissä 2-4 riippuen osallistujien määrästä. Vuorossa olevan kilpailijan nimi väritetään keltaisella. Toimintamalli on samanlainen kuin edellä mainitussa tikkalaskurissa. Yläosassa näytetään voittajan nimi tai "Tasapeli"-teksti, jos kaksi tai useampi osallistuja on kisan päättyessä tasapisteissä.
