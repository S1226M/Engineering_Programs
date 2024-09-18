# a = int(input("Enter the value of a :"))
# print("Square of the given number is :",a**2) # a*a

name = "smit"
print(len(name))
print(name[0:3]) # 0 is included but 3 is note included
print(name[-4:-1])
print("it is wrong",name[-1:-4])

# a="0123456789"
# a=[1:6:3]

print(name.endswith("it"))
print(name.startswith("it"))
print(name.capitalize())

a = "smit is a good boy \n but not a bad boy"
b = "smit is a good boy \n but not a bad \"boy\" 'boy' "
print(a)
print(b)

# c = input("Enter your name :")
# print(f"good afternoon {c}") #we can use the variable in the print function using the write 'f' before double cote

d = ''' Deare <|Name|> ,
            you are selected ! 
            <|Date|>'''
print(d.replace("<|Name|>","smit").replace("<|Date|>","10 25 2012"))

print(a.find("is"))

print(a.replace(" ","   "))#string is immutable means it is not change the vale of string