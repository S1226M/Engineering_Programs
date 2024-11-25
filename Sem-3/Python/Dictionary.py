marks = {
    "smit" : "100",
    "jainil" :  "200"
}

print(marks,type(marks))
print(marks["jainil"])
print(marks.items())
print(marks.keys())
print(marks.values())
marks.update({"smit":99 ,  "Bhavy":101})
print(marks,type(marks))
print(marks)

# Both are not same
# print(marks.get("smit2222")) # return nun
# print(marks["smit2222"]) # return the error

