#version 300 es
out vec4 FragColor;

in vec3 ourColor;
in vec2 TexCoord;

// texture sampler
uniform sampler2D texture0;
uniform sampler2D texture1;
uniform float mixValue;

void main()
{
    // 翻转
    vec2 flippedTexCoordy = vec2(TexCoord.x, 1.0 - TexCoord.y);
    // 翻转第二个纹理
    vec2 flippedTexCoordX = vec2(1.0 - TexCoord.x, 1.0 - TexCoord.y);
    FragColor = mix(texture(texture0, flippedTexCoordy), texture(texture1, flippedTexCoordX), mixValue);
}