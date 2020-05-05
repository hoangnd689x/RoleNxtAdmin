import { Domain } from './domain';
import { Organization } from './organization';

export class Position {
    id: number;
    organization: number;
    name: string;
    organizationObj: Organization
}