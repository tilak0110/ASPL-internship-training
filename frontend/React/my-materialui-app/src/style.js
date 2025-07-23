// src/style.js
import { css } from '@emotion/react';

export const customHeading = css`
  color: #1565c0;
  letter-spacing: 2px;
  text-align: center;
  margin-bottom: 32px;
`;

export const rootContainer = css`
  padding: 48px 16px;
  background: linear-gradient(135deg, #e3f2fd 0%, #fff 100%);
  min-height: 100vh;
`;

// Example for MUI's sx prop:
export const paperStyle = {
  padding: '32px',
  borderRadius: '16px',
  boxShadow: '0 8px 32px rgba(21,101,192,0.1)',
  background: '#fff',
};
