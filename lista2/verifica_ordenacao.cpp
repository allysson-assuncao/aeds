#include <iostream>
#include <vector>

using namespace std;

bool isSorted(const vector<int>& vet, int& numComparisons, const int index) {
    numComparisons++;
    if (index == vet.size() - 1) return true;
    numComparisons++;
    if (vet[index] > vet[index + 1]) return false;
    return isSorted(vet, numComparisons, index + 1);
}

int main() {
    int n, numComparisons = 0;

    cout << "Digite o tamanho do vetor: " << endl;
    cin >> n;

    vector<int> vet(n);
    cout << "Digite os elementos do vetor: " << endl;
    for (int i = 0; i < n; i++) {
        cin >> vet[i];
    }

    if (isSorted(vet, numComparisons, 0)) {
        cout << "O vetor esta ordenado em ordem crescente." << endl;
    } else {
        cout << "O vetor nao esta ordenado." << endl;
    }

    cout << "Numero de comparacoes: " << numComparisons << endl;

    return 0;
}
