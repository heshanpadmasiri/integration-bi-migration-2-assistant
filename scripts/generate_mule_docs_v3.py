# Copyright (c) 2025, WSO2 LLC. (http://www.wso2.com).
#
# WSO2 LLC. licenses this file to you under the Apache License,
# Version 2.0 (the "License"); you may not use this file except
# in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied. See the License for the
# specific language governing permissions and limitations
# under the License.

import os

# Get the root directory of the project
root_dir = os.path.abspath(os.path.join(os.path.dirname(__file__), '..'))

# Define the relative paths from the root directory
relative_samples_dir = 'mule/src/test/resources/mule/v3/blocks'
relative_output_md_path = 'mule/docs/palette-item-mappings-v3.md'
relative_readme_md_path = 'mule/README.md'
relative_dw_md_path = 'mule/docs/dataweave-mappings-v3.md'
relative_dataweave_dir = os.path.join(relative_samples_dir, 'transform-message')

# Construct the absolute paths
samples_dir = os.path.join(root_dir, relative_samples_dir)
output_md_path = os.path.join(root_dir, relative_output_md_path)
readme_md_path = os.path.join(root_dir, relative_readme_md_path)
dw_md_path = os.path.join(root_dir, relative_dw_md_path)
dataweave_md_path = os.path.join(root_dir, dw_md_path)
dataweave_dir = os.path.join(root_dir, relative_dataweave_dir)
dataweave_files_dir = os.path.join(dataweave_dir, 'dataweave-files')
dataweave_bal_files_dir = os.path.join(dataweave_dir, 'dataweave-bal-files')

# List all files in the directory and its subdirectories
all_files = []
for root, dirs, files in os.walk(samples_dir):
    for file in files:
        all_files.append(os.path.join(root, file))

# Sort all files to ensure consistent order
all_files.sort()

# Filter XML and BAL files
xml_files = [f for f in all_files if f.endswith('.xml')]
bal_files = [f for f in all_files if f.endswith('.bal')]

# Group files by their immediate parent directory
grouped_files = {}
for file in xml_files + bal_files:
    parent_dir = os.path.basename(os.path.dirname(file))
    if parent_dir == 'unsupported-block' or parent_dir == 'dataweave-bal-files':
        continue
    if parent_dir not in grouped_files:
        grouped_files[parent_dir] = {'xml': [], 'bal': []}
    if file.endswith('.xml'):
        grouped_files[parent_dir]['xml'].append(file)
    elif file.endswith('.bal'):
        grouped_files[parent_dir]['bal'].append(file)

# Sort files within each group to ensure consistent order
for files in grouped_files.values():
    files['xml'].sort()
    files['bal'].sort()

# Pair XML and BAL files based on their names within each group
paired_files = {}
for parent_dir, files in grouped_files.items():
    paired_files[parent_dir] = []
    for xml_file in files['xml']:
        base_name = os.path.splitext(os.path.basename(xml_file))[0]
        for bal_file in files['bal']:
            if base_name in os.path.basename(bal_file):
                paired_files[parent_dir].append((xml_file, bal_file))
                break

# Function to read file content
def read_file_content(file_path):
    with open(file_path, 'r') as file:
        return file.read()

# Sort the paired_files dictionary by parent_dir keys in alphabetical order
sorted_paired_files = dict(sorted(paired_files.items()))

# Generate Markdown content for samples
markdown_content = '# Sample Input and Output (Mule 3.x)\n\n'
markdown_content += 'The `mule-to-ballerina-migration-assistant` project includes sample input and output files to demonstrate the conversion process. These samples are located in the `mule/src/test/resources/mule/v3/blocks` directory.\n\n'

for parent_dir, pairs in sorted_paired_files.items():

    markdown_content += f'## {parent_dir.replace("-", " ").title()}\n\n'
    if parent_dir == 'transform-message':
        markdown_content += f'See [DataWeave Samples (Mule 3.x)](dataweave-mappings-v3.md) for more details on Dataweave conversions.\n\n'
    for xml_file, bal_file in pairs:
        # TODO: Filter out display samples by a tag or something
        input_content = read_file_content(xml_file)
        output_content = read_file_content(bal_file)
        example_title = os.path.splitext(os.path.basename(xml_file))[0].replace("_", " ").title()

        markdown_content += f'- ### {example_title}\n\n'
        markdown_content += f'**Input ({os.path.basename(xml_file)}):**\n```xml\n{input_content}\n```\n'
        markdown_content += f'**Output ({os.path.basename(bal_file)}):**\n```ballerina\n{output_content}\n```\n\n'

# List directories to identify supported Mule components
supported_components = sorted([d for d in os.listdir(samples_dir) if os.path.isdir(os.path.join(samples_dir, d)) and d != 'unsupported-block'])

# Generate DataWeave samples

# List DWL and BAL files
dwl_files = sorted([f for f in os.listdir(dataweave_files_dir) if f.endswith('.dwl')])
bal_files = sorted([f for f in os.listdir(dataweave_bal_files_dir) if f.endswith('.bal')])

# Function to generate heading from filename
def generate_heading(file_name):
    title = file_name.replace('transform_message_with_', '').replace('_', ' ').title()
    return title + ' Expression'

# Pair DWL and BAL files based on their names
paired_files = {}
for dwl_file in dwl_files:
    base_name = os.path.splitext(dwl_file)[0]
    matching_bal_file = next((bal for bal in bal_files if base_name in bal), None)
    if matching_bal_file:
        paired_files[base_name] = (dwl_file, matching_bal_file)

# Generate Markdown content for DataWeave Samples
dataweave_markdown_content = '# DataWeave to Ballerina Transformations (Mule 3.x)\n\n'
dataweave_markdown_content += 'This section provides examples of DataWeave scripts and their corresponding Ballerina implementations.\n\n'

for base_name, (dwl_file, bal_file) in paired_files.items():
    heading = generate_heading(base_name)
    dwl_content = read_file_content(os.path.join(dataweave_files_dir, dwl_file))
    bal_content = read_file_content(os.path.join(dataweave_bal_files_dir, bal_file))

    dataweave_markdown_content += f'## {heading}\n\n'
    dataweave_markdown_content += f'**DataWeave Script ({dwl_file}):**\n```dataweave\n{dwl_content}\n```\n\n'
    dataweave_markdown_content += f'**Ballerina Output ({bal_file}):**\n```ballerina\n{bal_content}\n```\n\n'

# Read README.md content
with open(readme_md_path, 'r') as file:
    readme_content = file.readlines()

# Find the start and end index of the Supported Mule Components section
start_index = readme_content.index('## Supported Mule 3.x Components\n') + 1
end_index = start_index
while end_index < len(readme_content) and not readme_content[end_index].startswith('## '):
    end_index += 1

# Replace the old list with the new list
component_section_root_md = '(This section is AUTO-GENERATED by the test suite)\n\n'
component_section_root_md += 'The migration tool currently supports the following Mule components:\n\n'
component_list = ''
for component in supported_components:
    component_title = component.replace("-", " ").title()
    component_link = component.lower().replace(" ", "-")
    component_section_root_md += f'- [{component_title}](docs/palette-item-mappings-v3.md#{component_link})\n'
    component_list += f'- [{component_title}](palette-item-mappings-v3.md#{component_link})\n'

component_section_root_md += '\n'

# Find the start and end index of the Supported DataWeave Transformations section
dw_start_index = readme_content.index('## Supported DataWeave Transformations (DataWeave 1.0)\n') + 1
dw_end_index = dw_start_index
while dw_end_index < len(readme_content) and not readme_content[dw_end_index].startswith('## '):
    dw_end_index += 1

# Update README.md to include links to DataWeave headings
dataweave_section_root_md = '(This section is AUTO-GENERATED by the test suite)\n\n'
dataweave_section_root_md += 'The migration tool currently supports the following DataWeave transformations and their corresponding Ballerina implementations:\n\n'
supported_dw_list = ''
for base_name in paired_files.keys():
    heading = generate_heading(base_name)
    dataweave_section_root_md += f'- [{heading}](docs/dataweave-mappings-v3.md#{heading.lower().replace(" ", "-")})\n'
    supported_dw_list += f'- [{heading}](dataweave-mappings-v3.md#{heading.lower().replace(" ", "-")})\n'

dataweave_section_root_md += '\n'

# Replace the old mule component and dataweave sections with the new ones
readme_content = readme_content[:start_index] + [component_section_root_md] + readme_content[end_index:dw_start_index] + [dataweave_section_root_md] + readme_content[dw_end_index:]

# Write the Markdown content to the output file
with open(output_md_path, 'w') as file:
    file.write('###### This markdown file is AUTO-GENERATED by the test suite. Do not modify manually. ######\n\n')
    file.write('# Supported Mule 3.x Components\n\n')
    file.write(component_list)
    file.write(markdown_content)

print(f'>> Mule component samples have been extracted and written to {output_md_path}')

# Write the DataWeave Markdown content
with open(dataweave_md_path, 'w') as file:
    file.write('###### This markdown file is AUTO-GENERATED by the test suite. Do not modify manually. ######\n\n')
    file.write('# Supported Dataweave 1.0 (Mule 3.x) Constructs\n\n')
    file.write(supported_dw_list)
    file.write(dataweave_markdown_content)

print(f'>> Mule DataWeave samples have been extracted and written to {dataweave_md_path}')

# Write the updated README.md content
with open(readme_md_path, 'w') as file:
    file.writelines(readme_content)

print(f'>> \'Supported Mule Components\' section has been updated in {readme_md_path}')
print(f'>> \'Supported DataWeave Transformations\' section has been updated in {readme_md_path}')
