from teque2 import Teque2

def Hovedprogram():
    antallKommandoer = int(input("Hvor mange kommandoer vil du legge inn?"))
    liste = Teque2()

    for i in range(antallKommandoer):
        brukerInput = input("Hva slags kommando?").strip().split()
        kommando = brukerInput[0]
        element = int(brukerInput[1])

        if kommando == "push_front":
            liste.push_front(element)
        
        elif kommando == "push_back":
            liste.push_back(element)

        elif kommando == "push_middle":
            liste.push_middle(element)

        else:
            print(liste.get((element)))

Hovedprogram()

        