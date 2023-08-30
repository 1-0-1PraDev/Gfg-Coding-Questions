// Question : /* 1189. Maximum Number of Balloons */
public int maxNumberOfBalloons(String text) {
    int freqMap[] = new int[26];
    for(char ch : text.toCharArray()){
        freqMap[ch - 'a']++;
    }

    return IntStream.of(
        freqMap['b' - 'a'],
        freqMap['a' - 'a'],
        freqMap[('l' - 'a')] / 2,
        freqMap[('o' - 'a')] / 2,
        freqMap['n' - 'a']
    ).min().getAsInt();
}
// Input: text = "loonbalxballpoon"
// Output: 2

// We could also use int array instead of IntStream.of() in this particular case as follows
int[] frequencies = new int[26]; // Assuming an array for English alphabet characters
// ... Populate the frequencies array ...

int result = Math.min(Math.min(Math.min(frequencies['b' - 'a'], frequencies['a' - 'a']),
                                frequencies['l' - 'a'] / 2),
                                Math.min(frequencies['o' - 'a'] / 2, frequencies['n' - 'a']));

// But that would mean we need to use Math.min() frequently because we can only compare 2 values using Math.min()
// in single call where as we can create Stream of integers using IntStream.of() and can easily get minimum out of group.

/* IntStream.of() method to create a stream of integers from the specified values. This can be useful in 
scenarios where you want to operate on a group of values in a more functional programming style. */
