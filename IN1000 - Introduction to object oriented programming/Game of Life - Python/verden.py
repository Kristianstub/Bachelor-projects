from rutenett import Rutenett
class Verden:
    def __init__(self, rader, kolonner):
        self._rutenett = Rutenett(rader, kolonner)
        self._generasjonsnummer = 0
        self._rutenett.fyll_med_tilfeldige_celler()
        self._rutenett.koble_celler()

    def tegn(self):
        self._rutenett.tegn_rutenett()
        print("")
        print(f"Dette er {self._generasjonsnummer}. generasjon.")
        print(f"Det er {self._rutenett.antall_levende()} levende celler.")

    def oppdatering(self):
        for celle in self._rutenett.hent_alle_celler():
            celle.tell_levende_naboer()
        for celle in self._rutenett.hent_alle_celler():
            celle.oppdater_status()
        self._generasjonsnummer += 1
