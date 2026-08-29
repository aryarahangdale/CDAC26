#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;

// Compute RMS: sqrt(sum of squares / n) - using pointer arithmetic only
double computeRMS(double* signal, int n) {
    double sumSquares = 0;
    double* ptr = signal;
    
    for (int i = 0; i < n; i++) {
        sumSquares += (*ptr) * (*ptr);
        ptr++;
    }
    
    return sqrt(sumSquares / n);
}

// Normalize: divide every element by max absolute value - in-place
void normalise(double* signal, int n) {
    // Find max absolute value
    double maxVal = 0;
    double* ptr = signal;
    
    for (int i = 0; i < n; i++) {
        if (fabs(*ptr) > maxVal) {
            maxVal = fabs(*ptr);
        }
        ptr++;
    }
    
    if (maxVal == 0) return;  // Avoid division by zero
    
    // Divide every element by max
    ptr = signal;
    for (int i = 0; i < n; i++) {
        *ptr = *ptr / maxVal;
        ptr++;
    }
}

// Count zero crossings: count where adjacent elements have opposite signs
int countZeroCrossings(double* signal, int n) {
    int count = 0;
    double* ptr = signal;
    
    for (int i = 0; i < n - 1; i++) {
        double current = *ptr;
        double next = *(ptr + 1);
        
        // Check if signs are opposite
        if ((current < 0 && next > 0) || (current > 0 && next < 0)) {
            count++;
        }
        ptr++;
    }
    
    return count;
}

// Apply gain: multiply every element by gain factor - in-place
void applyGain(double* signal, int n, double gainFactor) {
    double* ptr = signal;
    
    for (int i = 0; i < n; i++) {
        *ptr = *ptr * gainFactor;
        ptr++;
    }
}

// Helper function to print array
void printArray(double* signal, int n, const string& label) {
    cout << label << ": ";
    double* ptr = signal;
    for (int i = 0; i < n; i++) {
        cout << fixed << setprecision(2) << *ptr << " ";
        ptr++;
    }
    cout << endl;
}

int main() {
    double testSignal[] = {0.5, -1.2, 0.8, -0.3, 1.0, -0.9, 0.1};
    int n = 7;
    
    // Make a copy for modification
    double signal[7];
    for (int i = 0; i < 7; i++) {
        signal[i] = testSignal[i];
    }

    // Compute RMS
    double rms = computeRMS(signal, n);
    cout << "RMS: " << fixed << setprecision(4) << rms << endl;

    // Count zero crossings
    int crossings = countZeroCrossings(signal, n);
    cout << "Zero Crossings: " << crossings << endl;

    // Copy original for normalise test
    for (int i = 0; i < 7; i++) {
        signal[i] = testSignal[i];
    }

    // Print before normalize
    printArray(signal, n, "Before normalise");

    // Normalize
    normalise(signal, n);

    // Print after normalize
    printArray(signal, n, "After normalise");

    // Apply gain (gain factor = 2.0)
    cout << "\nApplying gain factor 2.0..." << endl;
    applyGain(signal, n, 2.0);

    // Print after gain
    printArray(signal, n, "After applyGain(2.0)");

    return 0;
}
