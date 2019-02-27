# logical operation example
print(True and False)
print(True or False)
print(not True)

# enhance input-and-output.py
input_id = input("아이디를 입력해주세요.\n")
input_pwd = input("비밀번호를 입력해주세요.\n")
real_id = "joowon"
real_pwd = "asdf"

if real_id == input_id and real_pwd == input_pwd:
	print("Hello!")
else:
	print("Login Failed...")
