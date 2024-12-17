class Teque2:
    def __init__(self):
        self._liste = []
    
    def push_back(self, element):
        self._liste.append(element)
    
    def push_front(self, element):
        self._liste.insert(0, element)
    

    def push_middle(self, element):
        self._liste.insert(round(0, round(len(self._liste)/2)))


    def get (self, indeks):
        return self._liste[indeks]
