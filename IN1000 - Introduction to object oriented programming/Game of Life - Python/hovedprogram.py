from verden import Verden

"""Oppgave 4 i verden gir ikke mening, programmet kan ikke utvides til 
å kalle på oppdatering fordi det ikke er noe å oppdatere."""
def hovedprogram():
    verden1 = Verden(int(input("Oppgi antall rader i rutenettet")), int(input("Oppgi antall kolonner i rutenettet")))
    verden1.tegn()
    brukerinput = input("Skriv q for å avslutte programmet, trykk enter for å fortsette.")
    while brukerinput != "q":
        verden1.oppdatering()
        verden1.tegn()
        brukerinput = input("Skriv q for å avslutte programmet, trykk enter for å fortsette.")

# starte hovedprogrammet
hovedprogram()