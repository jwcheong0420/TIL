# import whole module
import joo
print(joo.a())

# import function
from joo import a
print(a())

# alias
from joo import a as z
import joo as k
print(z())
print(k.a())