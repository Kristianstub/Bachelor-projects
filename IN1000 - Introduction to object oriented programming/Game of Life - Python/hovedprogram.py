from verden import Verden


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
