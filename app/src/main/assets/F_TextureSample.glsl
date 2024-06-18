#version 300 es
out vec4 FragColor;

in vec3 ourColor;
in vec2 TexCoord;

// texture sampler
uniform sampler2D texture0;
uniform sampler2D texture1;

void main()
{
    vec2 flippedTexCoord = vec2(TexCoord.x, 1.0 - TexCoord.y);
    FragColor = mix(texture(texture0, flippedTexCoord), texture(texture1, flippedTexCoord), 0.2);
}