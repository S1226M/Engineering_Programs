#we can not change the value of the old string
frinds = ["smit" , "maru" , 10 , 10.256 , False , "rohan"]
print(frinds[0])
frinds[0] = "ABC" # string is mutable
print(frinds[0])
print(frinds[0:2])

frinds.append("jasnfkjaz")
print(frinds)

# methods of the list
''' 
    short
    reverse
    insert(insert index , what you insert) 
    pop(index)
    remove(val)
'''

#tuple
a=(1,)
b=(1,"ksnmflk",False) # we cann not change the value of tupple
print(type(a))
print(type(b))
#method of tupple
'''
    count(val) how maney time come in the tupple tha value it will return
    index(val) find from the tupple and if two value are present in the one tupple then it can give the first value fron the tupple
    len(tupplw variable name)
'''
  