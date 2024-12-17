class Celle:
    # Konstruktør
    def __init__(self):
        self._status = "doed"
        self._naboer = []
        self._ant_levende_naboer = 0
    
    def sett_doed(self):
        self._status = "doed"

    def sett_levende(self):
        self._status = "levende"

    def legg_til_nabo(self, nabo):
        self._naboer.append(nabo)

    def er_levende(self):
        if self._status == "levende":
            return True
        return False

    def hent_status(self):
        pass

    def hent_status_tegn(self):
        if self.er_levende():
            return "O"
        return "."

    def tell_levende_naboer(self): 
        antall = 0
        for celle in self._naboer:
            if celle.er_levende():
                antall +=1
        self._ant_levende_naboer = antall
    
    def oppdater_status(self):
        #Hvis den er død, blir den levende om den har nøyaktig 3 naboer.
        if not self.er_levende():
            if self._ant_levende_naboer == 3:
                self.sett_levende()
        #Hvis den lever, og har mindre enn 2 eller flere enn 3 naboer, så dør den ellers fortsetter den å leve.
        else:
            if self._ant_levende_naboer < 2:
                self.sett_doed()
            elif self._ant_levende_naboer > 3:
                self.sett_doed()

        
    