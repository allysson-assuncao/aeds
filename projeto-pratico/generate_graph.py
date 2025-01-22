import pandas as pd
import matplotlib.pyplot as plt

# Load the CSV file into a DataFrame
df = pd.read_csv('sort_results.csv')

# Plot the results
plt.figure(figsize=(10, 6))
for algorithm in df['Algorithm'].unique():
    subset = df[df['Algorithm'] == algorithm]
    for order in subset['Order'].unique():
        order_subset = subset[subset['Order'] == order]
        plt.plot(order_subset['Size'], order_subset['Time (ms)'], label=f'{algorithm} - {order}')

plt.title('Sorting Algorithm Performance')
plt.xlabel('Array Size')
plt.ylabel('Time (ms)')
plt.legend()
plt.grid(True)
plt.savefig('sorting_performance.png')
plt.show()