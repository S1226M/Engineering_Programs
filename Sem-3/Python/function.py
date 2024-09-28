# def avg():
#     a=(int(input("Enter the number a :")))
#     b=(int(input("Enter the number b :")))
#     c=(int(input("Enter the number c :")))
#     avg=(a+b+c)/3
#     print(avg)

# avg()
#without return
# def GoodDay(name , ending):
#     print("Good Day , " +name)
#     print(ending)

# GoodDay("Smit","Thank you")

#with return
# def GoodDay(name , ending): 
#     print("Good Day , " +name)
#     print(ending)
#     return  name


# a  = GoodDay("Smit","Thank you")
# print(a)


# If can not give the valuee of the variable in the function then it will cunsider THANK YOU and 
# if i give the value then it will print the value of the variable
# def GoodDay(name , ending = "TANK YOU"):

#     print(f"Good Day {name}")
#     print(ending)
#     return  name


# a  = GoodDay("Smit","THANKS")
# a  = GoodDay("Smit")
# print(a)

#recurson
def factorial(n):
    if(n==1 or  n==0):
        return 1
    return n*factorial(n-1)
a = factorial(5)
print(a)