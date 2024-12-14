#include <iostream>
#include <vector>

using namespace std;

int sumOfSquares(const vector<int>& vet, int& numComparisons, const int index) {
    numComparisons++;
    if (index == vet.size()) return 0;
    return vet[index] * vet[index] + sumOfSquares(vet, numComparisons, index + 1);
}

int main() {
    int n;
    int numComparisons = 0;

    cout << "Digite o tamanho do vetor: " << endl;
    cin >> n;

    vector<int> vet(n);
    cout << "Digite os elementos do vetor: " << endl;
    for (int i = 0; i < n; i++) {
        cin >> vet[i];
    }

    int sum = sumOfSquares(vet, numComparisons, 0);

    cout << "Soma dos quadrados dos elementos: " << sum << endl;

    cout << "Numero de comparacoes: " << numComparisons << endl;

    return 0;
}
