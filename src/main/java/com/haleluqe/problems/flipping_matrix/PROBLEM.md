# Flipping the Matrix

Sean has an \(2n \times 2n\) matrix. He can reverse any of its rows or any of its columns any number of times. The goal is to maximize the sum of the elements in the \(n \times n\) submatrix in the upper-left quadrant of the matrix.

Given \(q\) queries, each with a matrix configuration, determine the maximum possible sum of the upper-left \(n \times n\) matrix for each query.

## Example

```
matrix = [
  [1, 2],
  [3, 4]
]
```

Here \(n = 1\). The upper-left \(1 \times 1\) matrix starts with value \(1\).

1. Reverse row \(1\):

```
1 2
4 3
```

2. Reverse column \(0\):

```
4 2
1 3
```

The maximal sum is \(4\).

## Function Description

Complete the `flippingMatrix` function in the editor below.

`flippingMatrix` has the following parameter(s):

- `int matrix[2n][2n]`: a 2-dimensional array of integers

### Returns

- `int`: the maximum sum possible

## Input Format

The first line contains an integer \(q\), the number of queries.

The next \(q\) sets of lines each describe a query in the following format:

- The first line contains an integer \(n\).
- The next \(2n\) lines each contain \(2n\) space-separated integers describing a row of the matrix.

## Constraints

- \(1 \leq q \leq 16\)
- \(1 \leq n \leq 128\)
- \(0 \leq matrix[i][j] \leq 4096\), where \(0 \leq i, j < 2n\)

## Sample Input

```
STDIN           Function
-----           --------
1               q = 1
2               n = 2
112 42 83 119   matrix = [[112, 42, 83, 119], [56, 125, 56, 49],
56 125 56 49              [15, 78, 101, 43], [62, 98, 114, 108]]
15 78 101 43
62 98 114 108
```

## Sample Output

```
414
```

## Explanation

Start with matrix:

```
112  42  83 119
 56 125  56  49
 15  78 101  43
 62  98 114 108
```

Perform operations to maximize the sum of the \(n \times n\) upper-left quadrant:

1. Reverse column \(2\):

```
112  42 114 119
 56 125 101  49
 15  78  56  43
 62  98  83 108
```

2. Reverse row \(0\):

```
119 114  42 112
 56 125 101  49
 15  78  56  43
 62  98  83 108
```

The sum of values in the \(n \times n\) upper-left quadrant is:

\[
119 + 114 + 56 + 125 = 414
\]
