import { render } from '@testing-library/react';
import { test, expect } from 'vitest';
import App from './App';

test('Renderiza la aplicación principal', () => {
  render(<App />);
  
  expect(true).toBe(true); 
});