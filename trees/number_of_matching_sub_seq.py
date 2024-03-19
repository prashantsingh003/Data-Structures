class TreeNode:
    def __init__(self):
        self.children={}
        self.is_end_of_str=False
        self.word_freq=0
        self.is_sub_seq=False
class Tree:
    def __init__(self,sequence):
        self.root= TreeNode()
        self.root.is_sub_seq=True
        self.sequence=sequence

    def insert(self,s,freq=1):
        node=self.root
        for ch in s:
            if ch not in node.children:
                node.children[ch]=TreeNode()
            node = node.children[ch]
        node.is_end_of_str=True
        node.word_freq=freq
    def set_tree(self):
        self.set_sub_seq(self.sequence,self.root)
    
    def set_sub_seq(self,s,node):
        if s=='':
            return
        for key,child in node.children.items():
            ind=self.is_node_sub_seq(s,key,node.is_sub_seq)
            child.is_sub_seq=ind!=-1
            sub_s='' if ind==-1 else s[ind+1:]
            self.set_sub_seq(sub_s,child)

    def is_node_sub_seq(self,s,t,is_prev_subseq):
        if not is_prev_subseq:
            return -1 
        for i in range(len(s)):
            if s[i] ==t:
                return i
        return -1

    def get_sub_seq_count(self,node=None):
        if node is None:
            node=self.root
        count=0
        for key,child in node.children.items():
            if child.is_end_of_str and child.is_sub_seq:
                count+=child.word_freq
            count+=self.get_sub_seq_count(child)
        return count

    
from collections import Counter
words = ["qlhxagxdq","qlhxagxdq","lhyiftwtut","yfzwraahab"]
counter=Counter(words)

s = "qlhxagxdqh"
tree=Tree(s)
for word in counter:
    tree.insert(word,counter[word])
tree.set_tree()
print(tree.get_sub_seq_count())