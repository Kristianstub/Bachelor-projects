from random import randint
from celle import Celle

class Rutenett:
    def __init__(self, rader, kolonner):
        self._ant_rader = rader
        self._ant_kolonner = kolonner
        self._rutenett = self._lag_tomt_rutenett()


    def _lag_tomt_rutenett(self):
        liste = []
        for i in range(self._ant_rader):
            liste.append(self._lag_tom_rad())
        return liste


    def _lag_tom_rad(self):
        liste = []
        for x in range(self._ant_kolonner):
            liste.append(None)
        return liste

    def fyll_med_tilfeldige_celler(self):
        for rad in self._rutenett:
            radindeks = self._rutenett.index(rad)
            for kolonne in rad:
                kolonneindeks = rad.index(kolonne)
                self.lag_celle(radindeks, kolonneindeks)
                

    def lag_celle(self, rad, kol):
        celle = Celle()
        if randint(0,2) == 2:
            celle.sett_levende()
        self._rutenett[rad][kol] = celle


    def hent_celle(self, rad, kol):
        if rad in range(self._ant_rader) and kol in range(self._ant_kolonner):
            return self._rutenett[rad][kol]
        return None
        
    def tegn_rutenett(self):
        for i in range(10):
            print("")
        for rad in self._rutenett:
            print("")
            for kolonne in rad:
                print(kolonne.hent_status_tegn(), end="")

    """alle disse kombinasjonene med i = 1 og i = -1 vil tilsvare de 8 forskjellige rutene rundt en celle
    som vil gjøre at alle blir satt som nabo."""
    def _sett_naboer(self, rad, kol):
        celle = self.hent_celle(rad, kol)
        for i in [1, -1]:
            if self.hent_celle(rad + i, kol):
                celle.legg_til_nabo(self.hent_celle(rad + i, kol))
            if self.hent_celle(rad + i, kol + i):
                celle.legg_til_nabo(self.hent_celle(rad + i, kol + i))
            if self.hent_celle(rad , kol + i):
                celle.legg_til_nabo(self.hent_celle(rad , kol + i))
            if self.hent_celle(rad + i, kol - i):
                celle.legg_til_nabo(self.hent_celle(rad + i , kol -i))
    #Utfører _sett_naboer på hver eneste celle.
    def koble_celler(self):
        for rad in range(self._ant_rader):
            for kol in range(self._ant_kolonner):
                self._sett_naboer(rad, kol)

    def hent_alle_celler(self):
        liste = []
        for i in self._rutenett:
            for j in i:
                liste.append(j)
        return liste


    def antall_levende(self):
        teller = 0
        for i in self._rutenett:
            for j in i:
                if j.er_levende():
                    teller += 1
        return teller





#Endret linje 37 i testprogrammet