class Solution {
public int lengthOfLastWord(String s) {
int length=0;// we nedd to calculate the length of the last word in the string so initialize it with zero.........
// as we need to find the lenght of the last word so traverse from backwards
for(int i=s.length()-1;i>=0;i--)
{
if(s.charAt(i)!=' ')//The Java String class charAt() method returns a char value at the given index number.
{
length++;
}
else
{
// if it's a white space is encountered through backwards traversal it indicates that we found the last word
if (length > 0) return length;
}
}
return length;
}
}