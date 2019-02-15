input_id = input('아이디를 입력해주세요.\n')

def login(_id):
	members = ['joowon', 'k8805']
	for member in members:
		if member == input_id:
			return True
	return False

if login(input_id):
	print("Hello, " + input_id + "!")
else:
	print("Who are you?")