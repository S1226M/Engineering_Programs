class inheritance:
    def __init__(ref,name,age):
        ref.name = name
        ref.age = age

class Smit(inheritance):
    # You have redefined __init__ inside Smit. This is called Method Overriding.
    def __init__(ref,address):
        # if you are not erite this bellow line then it is Constructor Overriding.
        super().__init__("Smit",20)
        ref.address = address

    def display(ref):
        print(ref.address)

smit1 = Smit("123 Street")
smit1.display()