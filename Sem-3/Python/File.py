# open file
# f = open("abc.txt")
# data = f.read()
# print(data)
# f.close()

# write file
# f = open("abc.txt", "w")
# f.write("Hello, world!")
# f.close()

# more file function
# f = open("abc.txt")

# line = f.readline()
# print(line)
# line = f.readline()
# print(line)
# line = f.readline()
# print(line)
# line = f.readline()
# print(line)
# line = f.readline()
# print(line)

# line = f.readline()
# while line != '':
#     print(line)
#     line = f.readline()
# f.close()

# lines = f.readlines() #return the list
# print(lines , type(lines))
# f.close()

# modes of file
# r - open for read 
# w - open for write
# a - open for append
# + / ab - open for updating
# rb - open for read in binary mode
# rt - open for read in text mode
# wb - open for write in binary mode
# wt - open for write in text mode

# append
# f = open("abc.txt", "a")
# f.write("Hello, world!")
# f.close()

# with statement
f = open("abc.txt")
print(f.read())
f.close()

# the can be writen by the with statement like this
with open("abc.txt") as f:
    print(f.read())
# dont need to close the file, it will be closed automatically.

