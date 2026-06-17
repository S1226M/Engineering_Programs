class Smit:
    name = "Smit"
    age = 20
    
    def __init__(self, address):
        self.address = address

smit1 = Smit("")
print(smit1.name , smit1.age , type(smit1.address))

# A reference to the specific object being created
