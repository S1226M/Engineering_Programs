# n = int(input("Enter the number : "))

# for i in range(1,11):
#     print(f"{n} x {i} = {n*i}")

# l = ["smit","maru","abc","rajkot"]
# for name in l:
#     if(name.startswith("m")):
#         print(f"{name}")

# n = int(input("enter the number : "))

# count = 0
# for i in range(1,n+1):
    
#     if(n<1):
#         print("number is not prime")
#         break

#     if(n % i == 0):
#         count+=1
#     else:
#         continue
# if(count == 2):
#     print(f"{n} is prime number")
# else:
#     print("Given number is not prime")

n = int(input("Enter the number"))
ans = 1
for i in range(1,n+1):
    ans  = ans*i
print(f"the factorial of the give number is {ans}")

