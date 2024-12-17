import time
def lesFraFil(filnavn):
    usortertListe = []
    with open(filnavn) as fil:
        for linje in fil:
            #legger til hvert tall i listen
            usortertListe.append(int(linje.strip()))
    return usortertListe


    

def skrivtilfil(liste, filnavn):
    with open(filnavn, "w") as fil:
        for i in liste:
            fil.write(f"{i}\n")



def insertionsort(filnavn):
    liste = lesFraFil(filnavn)

    for i in range(1, len(liste)):

        j = i

        while liste[j] < liste[j-1] and j != 0:
            
            liste[j], liste[j-1] = liste[j-1], liste[j]
            j = j-1
    skrivtilfil(liste, f"{filnavn}_insertion.out.")

insertionsort("tall.txt")


        


        


