"""
Detect a cycle in a linked list. Note that the head pointer may be 'None' if the list is empty.

A Node is defined as: 
 
    class Node(object):
        def __init__(self, data = None, next_node = None):
            self.data = data
            self.next = next_node
"""


def has_cycle(head):
    hare = head
    tortoise = head
    while True:
        if hare.next and hare.next.next:
            hare = hare.next.next
            tortoise = tortoise.next
        else:
            return False
        if hare is tortoise:
            return True