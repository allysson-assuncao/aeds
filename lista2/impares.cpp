#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n, numComparisons = 0;

    cout << "Digite o tamanho do vetor: " << endl;
    cin >> n;

    vector<int> vet(n);
    cout << "Digite os elementos do vetor: " << endl;
    for (int i = 0; i < n; i++) {
        cin >> vet[i];
    }

    cout << "Vetor de impares: " << endl << "[";
    for (int value : vet) {
        numComparisons++;
        if(value % 2 != 0) {
            cout << value << ", ";
        }
    }
    cout << "fim]" << endl;

    cout << "Numero de comparacoes: " << numComparisons << endl;

    return 0;
}
