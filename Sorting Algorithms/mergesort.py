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

#lagde en til slik at jeg får skrevet den siste versjonen av listen til fil siden den returnerer på slutten av vanlige mergesort metoden
def mergesortHoved(filnavn):
    
    liste = lesFraFil(filnavn)
    nyfilnavn = f"{filnavn}_merge.out."
    skrivtilfil(mergesort(liste), nyfilnavn)

def mergesort(liste):

    if len(liste) <= 1:
        return liste

    i = round(len(liste)/2)
    A1 = mergesort(liste[:i])
    A2 = mergesort(liste[i:])
    return merge(A1, A2, liste)



def merge(liste1, liste2, sortertliste):
    i = 0
    j = 0
    while i < len(liste1) and j < len(liste2):
        if liste1[i] <= liste2[j]:
            sortertliste[i+j] = liste1[i]
            i = i + 1
        
        else:
            sortertliste[i+j] = liste2[j]
            j = j +1
    
    while i < len(liste1):
        sortertliste[i+j] = liste1[i]
        i = i +1

    while j < len(liste2):
        sortertliste[i+j] = liste2[j]
        j = j + 1

    return sortertliste



mergesortHoved("tall.txt")